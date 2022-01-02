package p2000_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/single-threaded-cpu/
 *
 * @author half-dead
 */
public class Puzzle1834 {

    class Solution {
        public int[] getOrder(int[][] tasks) {
            int len = tasks.length;
            int[][] arr = new int[len][3];
            for (int i = 0; i < len; i++) {
                arr[i][0] = tasks[i][0];
                arr[i][1] = tasks[i][1];
                arr[i][2] = i;
            }
            Arrays.sort(arr, (a, b) -> {
                int eqd = a[0] - b[0], pd = a[1] - b[1];
                if (eqd != 0) {
                    return eqd;
                } else if (pd != 0) {
                    return pd;
                } else {
                    return a[2] - b[2];
                }
            });

            PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[1]).thenComparingInt(a -> a[2]));

            int i = 0, j = 0, time = 0;
            int[] res = new int[len];
            while (i < len) {
                if (q.isEmpty()) {
                    q.offer(arr[j++]);
                }
                int[] top = q.poll();
                res[i++] = top[2];
                time = Math.max(time, top[0]) + top[1];

                while (j < len && arr[j][0] <= time) {
                    q.offer(arr[j++]);
                }
            }
            return res;
        }
    }
}
