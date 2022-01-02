/*
https://leetcode.com/problems/jump-game/description/

Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.

Example 1:
    Input: [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
    Input: [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum
                 jump length is 0, which makes it impossible to reach the last index.
 */

package p0500_;

/**
 * @author half-dead
 */
public class Puzzle055_JumpGame {

    public static void main(String[] args) {
        Solution s = new Puzzle055_JumpGame().new Solution();
        System.out.println(s.canJump(new int[]{0}));
    }

    class Solution {
        public boolean canJump(int[] nums) {
            int max = 0;
            for (int i = 0; i <= nums.length - 1; i++) {
                if (i <= max) {
                    max = Math.max(max, i + nums[i]);
                    if (max >= nums.length - 1) return true;
                }
            }
            return false;
        }
    }

    // Time Limit Exceeded
    class RecursiveSolution {
        public boolean canJump(int[] nums) {
            return canJump(nums, 0);
        }

        public boolean canJump(int[] nums, int position) {
            if (position >= nums.length - 1) {
                return true;
            }
            int maxStep = nums[position];
            for (int i = maxStep; i > 0; i--) {
                if (canJump(nums, position + i)) {
                    return true;
                }
            }
            return false;
        }
    }

    class Solution2 {
        public boolean canJump(int[] nums) {
            int left = 0, right = 0;
            while (left <= right) {
                int step = nums[left];
                int max = right;
                while (step >= 0) {
                    if (left + step >= nums.length - 1) return true;
                    int canReach = nums[left + step] + left + step;
                    max = Math.max(max, canReach);
                    step--;
                }
                left++;
                right = max;
            }
            return false;
        }
    }
}
