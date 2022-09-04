package p2500_;

import java.util.*;

/**
 * https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
 *
 * @author half-dead
 */
public class Puzzle2342 {
    class Solution {
        public int maximumSum(int[] nums) {
            Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
            for (int v : nums) {
                int x = v, sod = 0;
                while (x > 0) {
                    sod += x % 10;
                    x /= 10;
                }
                PriorityQueue<Integer> pq = map.computeIfAbsent(sod, t -> new PriorityQueue<>());
                pq.offer(v);
                if (pq.size() > 2) pq.poll();
            }
            int res = -1;
            for (PriorityQueue<Integer> pq : map.values()) {
                if (pq.size() == 2) {
                    res = Math.max(res, pq.poll() + pq.poll());
                }
            }
            return res;
        }
    }
}
