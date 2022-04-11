package p1000_;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/maximum-width-ramp/
 *
 * @author half-dead
 */
public class Puzzle962 {

    // monotonic stack
    class Solution {
        public int maxWidthRamp(int[] nums) {
            int n = nums.length, res = 0;

            Deque<Integer> dq = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (dq.size() == 0 || nums[i] < nums[dq.peek()]) {
                    dq.push(i);
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                while (dq.size() > 0 && nums[i] >= nums[dq.peek()]) {
                    res = Math.max(res, i - dq.pop());
                }
            }
            return res;
        }
    }
}
