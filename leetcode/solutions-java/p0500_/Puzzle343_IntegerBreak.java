/*
https://leetcode.com/problems/integer-break/description/

Given a positive integer n, break it into the sum of at least two positive integers
 and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58.
 */

package p0500_;

/**
 * @author half-dead
 */
public class Puzzle343_IntegerBreak {
    public static void main(String[] args) {
        Solution s = new Puzzle343_IntegerBreak().new Solution();
        for (int i = 2; i <= 58; i++) {
            System.out.println(i + " = " + s.integerBreak(i));
        }
    }

    class Solution {
        public int integerBreak(int n) {
            if (n < 4) {
                return n - 1;
            }
            int result = 1;
            while (n > 4) {
                result *= 3;
                n -= 3;
            }
            result *= n;
            return result;
        }
    }
}
