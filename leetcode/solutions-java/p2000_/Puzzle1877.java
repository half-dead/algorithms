package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
 *
 * @author half-dead
 */
public class Puzzle1877 {
    class Solution {
        public int minPairSum(int[] nums) {
            Arrays.sort(nums);
            int res = 0;
            for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
                res = Math.max(res, nums[i] + nums[j]);
            }
            return res;
        }
    }
}
