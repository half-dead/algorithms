package p0500_;

// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
// For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
// the contiguous subarray [4,−1,2,1] has the largest sum = 6.

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class Puzzle053_MaximumSubarray {

    public static void main(String[] args) {
        Puzzle053_MaximumSubarray p = new Puzzle053_MaximumSubarray();
        Solution solution = p.new Solution();
        int[] nums = new int[]{8, -19, 5, -4, 20};
        int sum = solution.maxSubArray(nums);
        System.out.println(sum);
    }

    public class Solution {
        public int maxSubArray(int[] nums) {
            int sum = nums[0], max = sum;
            for (int i = 1; i < nums.length; i++) {
                sum = sum <= 0 ? nums[i] : (sum + nums[i]);
                max = Math.max(max, sum);
            }
            return max;
        }
    }
}