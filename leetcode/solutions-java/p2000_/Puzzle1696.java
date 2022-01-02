package p2000_;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/jump-game-vi/
 *
 * @author half-dead
 */
public class Puzzle1696 {

    // dp + monotonic deque
    class Solution {
        public int maxResult(int[] nums, int k) {
            Deque<int[]> dq = new LinkedList<>();
            for (int i = nums.length - 1; i >= 0; i--) {
                int temp = nums[i] + (dq.isEmpty() ? 0 : dq.peekFirst()[0]);
                while (!dq.isEmpty() && dq.peekLast()[0] <= temp) dq.pollLast();
                if (!dq.isEmpty() && dq.peekFirst()[1] - i == k) dq.pollFirst();
                dq.offerLast(new int[]{temp, i});
            }
            return dq.peekLast()[0];
        }
    }

    // dp + priority queue
    class Solution1 {
        public int maxResult(int[] nums, int k) {
            int len = nums.length;
            int[] dp = new int[len];
            PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> {
                int diff = b[0] - a[0];
                return diff != 0 ? diff : (b[1] - a[1]);
            });
            for (int i = len - 1; i >= 0; i--) {
                while (pq.size() > 0 && pq.peek()[1] - i > k) pq.poll();
                dp[i] = nums[i] + (pq.isEmpty() ? 0 : pq.peek()[0]);
                pq.offer(new int[]{dp[i], i});
            }
            return dp[0];
        }
    }
}
