package p0500_;

// You are a professional robber planning to rob houses along a street. Each house has a certain
// amount of money stashed, the only constraint stopping you from robbing each of them is that
// adjacent houses have security system connected and it will automatically contact the police
// if two adjacent houses were broken into on the same night.
//
// Given a list of non-negative integers representing the amount of money of each house, determine
// the maximum amount of money you can rob tonight without alerting the police.

/**
 * https://leetcode.com/problems/house-robber/
 */
public class Puzzle198_HouseRobber {
    public static void main(String[] args) {
        Puzzle198_HouseRobber p = new Puzzle198_HouseRobber();
        Solution solution = p.new Solution();
        int rob = solution.rob(new int[]{7, 1, 2, 8, 1, 2, 9});
        System.out.println(rob);
    }

    public class Solution {
        public int rob(int[] nums) {
            int a = 0, b = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 0) {
                    a = a + nums[i];
                    a = a > b ? a : b;
                } else {
                    b = b + nums[i];
                    b = b > a ? b : a;
                }
            }
            return a > b ? a : b;
        }
    }
}
