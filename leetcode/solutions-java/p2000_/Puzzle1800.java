package p2000_;

/**
 * https://leetcode.com/problems/maximum-ascending-subarray-sum/
 *
 * @author half-dead
 */
public class Puzzle1800 {

    class Solution {
        public int maxAscendingSum(int[] nums) {
            int n = nums.length, res = nums[0], sum = nums[0];
            for (int i = 1; i < n; i++) {
                if (nums[i] > nums[i - 1]) {
                    sum += nums[i];
                    res = Math.max(res, sum);
                } else {
                    sum = nums[i];
                }
            }
            return res;
        }
    }
}
