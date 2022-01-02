package p0500_;

// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
// Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
// For example, given array S = {-1 2 1 -4}, and target = 1.
// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 */
public class Puzzle016_3SumClosest {

    public static void main(String[] args) {
        Puzzle016_3SumClosest p = new Puzzle016_3SumClosest();
        Solution s = p.new Solution();
        int[] nums = {13, 2, 0, -14, -20, 19, 8, -5, -13, -3, 20, 15, 20, 5, 13, 14, -17, -7, 12, -6, 0, 20, -19, -1, -15, -2, 8, -2, -9, 13, 0, -3, -18, -9, -9, -19, 17, -14, -19, -4, -16, 2, 0, 9, 5, -7, -4, 20, 18, 9, 0, 12, -1, 10, -17, -11, 16, -13, -14, -3, 0, 2, -18, 2, 8, 20, -15, 3, -13, -12, -2, -19, 11, 11, -10, 1, 1, -10, -2, 12, 0, 17, -19, -7, 8, -19, -17, 5, -5, -10, 8, 0, -12, 4, 19, 2, 0, 12, 14, -9, 15, 7, 0, -16, -5, 16, -12, 0, 2, -16, 14, 18, 12, 13, 5, 0, 5, 6};
        int sum = s.threeSumClosest(nums, -59);
        System.out.println(sum);
    }

    public class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int sum = nums[0] + nums[1] + nums[2];
            int gap = Math.abs(target - sum);
            for (int i = 0; i < nums.length - 2; i++) {
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    int tsum = nums[i] + nums[j] + nums[k];
                    int abs = Math.abs(target - tsum);
                    if (abs < gap) {
                        gap = abs;
                        sum = tsum;
                        while (j < k && nums[j] == nums[j + 1]) j++;
                        while (j < k && nums[k] == nums[k - 1]) k--;
                    }
                    if (tsum == target) {
                        return tsum;
                    } else if (tsum < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
            return sum;
        }
    }
}
