package p2500_;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
 *
 * @author half-dead
 */
public class Puzzle2279 {

    class Solution {
        public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
            int res = 0, n = rocks.length;
            long sum = 0L;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                int x = capacity[i] - rocks[i];
                if (x == 0) {
                    res++;
                } else {
                    pq.offer(x);
                    sum += x;
                }
            }
            if (sum <= additionalRocks) return n;
            while (additionalRocks >= pq.peek()) {
                additionalRocks -= pq.poll();
                res++;
            }
            return res;
        }
    }
}
