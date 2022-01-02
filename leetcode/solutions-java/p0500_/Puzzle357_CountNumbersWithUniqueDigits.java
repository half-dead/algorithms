/*
https://leetcode.com/problems/count-numbers-with-unique-digits/description/

Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 */
package p0500_;

/**
 * @author half-dead
 */
public class Puzzle357_CountNumbersWithUniqueDigits {

    public static void main(String[] args) {
        Solution s = new Puzzle357_CountNumbersWithUniqueDigits().new Solution();
        for (int i = 0; i < 15; i++) {
            System.out.println(s.countNumbersWithUniqueDigits(i));
        }
    }

    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) {
                return 1;
            } else if (n == 1) {
                return 10;
            }
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 9;
            int sum = 10;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] * (10 - i + 1);
                sum += dp[i];
            }
            return sum;
        }
    }
}
