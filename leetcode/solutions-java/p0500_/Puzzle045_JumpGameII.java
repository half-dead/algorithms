/*
https://leetcode.com/problems/jump-game-ii/description/

Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.

Example:
    Input: [2,3,1,1,4]
    Output: 2
    Explanation: The minimum number of jumps to reach the last index is 2.
        Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note:
    You can assume that you can always reach the last index.
 */

package p0500_;

/**
 * @author half-dead
 */
public class Puzzle045_JumpGameII {

    public static void main(String[] args) {
        Solution solution = new Puzzle045_JumpGameII().new Solution();
        System.out.println(solution.jump(new int[]{2, 1}));
    }


    class Solution {
        public int jump(int[] nums) {
            int[] dp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                while (i > 0 && i < nums.length && nums[i] < nums[i - 1]) {
                    i++;
                }
                if (i < nums.length) {
                    int count = dp[i] + 1;
                    for (int j = nums[i]; j > 0; j--) {
                        int idx = i + j;
                        if (idx < nums.length) {
                            if (dp[idx] == 0) {
                                dp[idx] = count;
                            } else {
                                dp[idx] = Math.min(dp[idx], count);
                            }
                        }
                    }
                }
            }
            return dp[dp.length - 1];
        }
    }

    class Solution2 {
        public int jump(int[] nums) {
            int jumps = 0, bound = 0, nextBound = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                int val = i + nums[i];
                if (nextBound < val) {
                    nextBound = val;
                }
                if (i == bound) {
                    jumps++;
                    bound = nextBound;
                }
            }

            return jumps;

        }
    }
}
