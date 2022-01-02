package p2000_;

/**
 * https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/
 *
 * @author half-dead
 */
public class Puzzle1909 {

    class Solution {
        public boolean canBeIncreasing(int[] nums) {
            boolean b = false;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] >= nums[i]) {
                    if (b) return false;

                    if (i == 1 || nums[i - 2] < nums[i]) {
                        b = true;
                    } else if (i == nums.length - 1 || nums[i - 1] < nums[i + 1]) {
                        b = true;
                        i++;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
