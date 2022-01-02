package p1000_;

/**
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 *
 * @author half-dead
 */
public class Puzzle918 {

    public static void main(String[] args) {
        Solution s = new Puzzle918().new Solution();
        System.out.println(s.maxSubarraySumCircular(new int[]{9, -4, -7, 9}));
    }


    // one pass, kadane's algorithm
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int len = nums.length, sum1 = nums[0], sum2 = nums[0], total = nums[0];
            int min = nums[0], max = nums[0];
            for (int i = 1; i < len; i++) {
                sum1 = Math.max(0, sum1) + nums[i];
                max = Math.max(max, sum1);

                sum2 = Math.min(0, sum2) + nums[i];
                min = Math.min(min, sum2);

                total += nums[i];
            }
            return max <= 0 ? max : Math.max(max, total - min);
        }
    }
}
