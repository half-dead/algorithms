package p1000_;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-cost-to-hire-k-workers/
 *
 * @author half-dead
 */
public class Puzzle857 {

    // greedy, priority queue
    class Solution {
        public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
            int n = wage.length, sum = 0;

            // use two dimension array too avoid double calculation
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = wage[i];
                arr[i][1] = quality[i];
            }
            // sort by wage/quality
            Arrays.sort(arr, (a, b) -> a[0] * b[1] - b[0] * a[1]);

            double min = Double.MAX_VALUE;
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            for (int i = 0; i < n; i++) {
                // pq.size() reached k, need to remove someone
                if (pq.size() == k) sum -= pq.poll();

                pq.offer(arr[i][1]);
                sum += arr[i][1];
                if (pq.size() == k) {
                    double ratio = (double) arr[i][0] / arr[i][1];
                    min = Math.min(min, sum * ratio);
                }
            }
            return min;
        }
    }
}
