package p2000_;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/maximum-number-of-eaten-apples/
 *
 * @author half-dead
 */
public class Puzzle1705 {

    class Solution {
        public int eatenApples(int[] apples, int[] days) {
            int d = 1, cnt = 0, n = apples.length;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            for (int i = 0; i < n || pq.size() > 0; i++) {
                if (i < n && apples[i] > 0) {
                    pq.offer(new int[]{days[i] + d, apples[i]});
                }
                while (pq.size() > 0 && pq.peek()[0] <= d) {
                    pq.poll();
                }
                if (pq.size() > 0) {
                    if (pq.peek()[1]-- == 1) {
                        pq.poll();
                    }
                    cnt++;
                }
                d++;
            }
            return cnt;
        }
    }
}
