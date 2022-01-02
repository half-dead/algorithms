package p2500_;

/**
 * https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/
 *
 * @author half-dead
 */
public class Puzzle2044 {

    // backtracking, O(2^N) time
    class BacktrackingSolution {
        public int countMaxOrSubsets(int[] nums) {
            int or = 0;
            for (int v : nums) or |= v;

            int[] res = new int[1];
            bt(nums, 0, 0, or, res);
            return res[0];
        }

        void bt(int[] nums, int i, int curr, int target, int[] res) {
            if (curr == target) {
                res[0] += 1 << (nums.length - i);
                return;
            }

            for (int j = i; j < nums.length; j++) {
                bt(nums, j + 1, curr | nums[j], target, res);
            }
        }
    }

    // DP
    class Solution {
        public int countMaxOrSubsets(int[] nums) {
            int[] dp = new int[1 << 17];
            dp[0] = 1;

            int max = 0;
            for (int n : nums) {
                for (int i = max; i >= 0; i--) {
                    dp[i | n] += dp[i];
                }
                max |= n;
            }
            return dp[max];
        }
    }

}
