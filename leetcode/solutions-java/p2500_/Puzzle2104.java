package p2500_;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/sum-of-subarray-ranges/
 *
 * @author half-dead
 */
public class Puzzle2104 {

    // monotone stack, O(N) time & space
    class Solution {
        public long subArrayRanges(int[] nums) {
            Deque<Integer> dq = new LinkedList<>();
            long res = 0L;
            int n = nums.length;
            for (int i = 0; i <= n; i++) {
                while (dq.size() > 0 && (i == n || nums[dq.peek()] <= nums[i])) {
                    int mid = dq.pop();
                    int left = dq.size() == 0 ? -1 : dq.peek();
                    res += (long) nums[mid] * (i - mid) * (mid - left);
                }
                if (i < n) dq.push(i);
            }

            for (int i = 0; i <= n; i++) {
                while (dq.size() > 0 && (i == n || nums[dq.peek()] >= nums[i])) {
                    int mid = dq.pop();
                    int left = dq.size() == 0 ? -1 : dq.peek();
                    res -= (long) nums[mid] * (i - mid) * (mid - left);
                }
                if (i < n) dq.push(i);
            }
            return res;
        }
    }
}
