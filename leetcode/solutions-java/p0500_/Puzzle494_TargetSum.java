/*
https://leetcode.com/problems/target-sum/description/

You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
    Input: nums is [1, 1, 1, 1, 1], S is 3.
    Output: 5
    Explanation:
        -1+1+1+1+1 = 3
        +1-1+1+1+1 = 3
        +1+1-1+1+1 = 3
        +1+1+1-1+1 = 3
        +1+1+1+1-1 = 3
    There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
    The length of the given array is positive and will not exceed 20.
    The sum of elements in the given array will not exceed 1000.
    Your output answer is guaranteed to be fitted in a 32-bit integer.
 */

package p0500_;

/**
 * @author half-dead
 */
public class Puzzle494_TargetSum {

    public static void main(String[] args) {
        RecursiveSolution rs = new Puzzle494_TargetSum().new RecursiveSolution();
        Solution ss = new Puzzle494_TargetSum().new Solution();
        System.out.println(rs.findTargetSumWays(new int[]{3, 5}, 4));
        System.out.println(ss.findTargetSumWays(new int[]{3, 5}, 4));
    }

    class Solution {
        public int findTargetSumWays(int[] nums, int s) {
            int sum = 0;
            for (int i : nums) {
                sum += i;
            }
            if (sum < s || ((sum + s) & 1) != 0) {
                return 0;
            }
            return dp(nums, (sum + s) >> 1);
        }

        public int dp(int[] nums, int sum) {
            int[] knapsack = new int[sum + 1];
            knapsack[0] = 1;
            for (int n : nums) {
                for (int i = sum; i >= n; i--) {
                    knapsack[i] += knapsack[i - n];
                }
            }
            return knapsack[sum];
        }
    }

    class RecursiveSolution {
        public int findTargetSumWays(int[] nums, int s) {
            int sum = 0;
            for (int i : nums) {
                sum += i;
            }
            return recur(nums, 0, nums.length, s, sum);
        }

        public int recur(int[] nums, int begin, int end, int sum, int limit) {
            if (begin == end) {
                return sum == 0 ? 1 : 0;
            }
            if (limit < sum || -limit > sum) {
                return 0;
            }
            if (nums[begin] == 0) {
                return 2 * recur(nums, begin + 1, end, sum, limit);
            }
            return recur(nums, begin + 1, end, sum + nums[begin], limit - nums[begin]) +
                    recur(nums, begin + 1, end, sum - nums[begin], limit + nums[begin]);
        }
    }
}
