package p2000_;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/
 *
 * @author half-dead
 */
public class Puzzle1827 {

    class Solution {
        public int minOperations(int[] nums) {
            int res = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] >= nums[i]) {
                    res += nums[i - 1] + 1 - nums[i];
                    nums[i] = nums[i - 1] + 1;
                }
            }
            return res;
        }
    }
}
