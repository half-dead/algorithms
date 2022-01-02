package p0500_;

/**
 * https://leetcode.com/problems/wiggle-subsequence/
 *
 * @author half-dead
 */
public class Puzzle376 {

    // Greedy, O(N) time, O(1) space
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            int n = nums.length, max = 1;
            if (n < 2) return n;

            for (int delta = 0, i = 1; i < n; i++) {
                int diff = nums[i] - nums[i - 1];
                if (diff == 0) continue;

                if (delta == 0) {
                    delta = diff;
                    max = 2;
                } else if (delta * diff < 0) {
                    delta = diff;
                    max++;
                } else {
//                    delta += diff;
                }
            }
            return max;
        }
    }
}
