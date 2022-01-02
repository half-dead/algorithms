/*
https://leetcode.com/problems/bitwise-and-of-numbers-range/description/

Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:
    Input: [5,7]
    Output: 4
Example 2:
    Input: [0,1]
    Output: 0
 */

package p0500_;

/**
 * @author half-dead
 */
public class Puzzle201_BitwiseAndOfNumberRange {
    class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            if (m == n) {
                return m;
            }
            int xor = m ^ n;
            int count = 0;
            while (xor > 0) {
                count++;
                xor >>= 1;
            }
            return m & n & (-(1 << count));
        }
    }

    class NeatSolution {
        public int rangeBitwiseAnd(int m, int n) {
            while (n != 0 && m < n) {
                n = n & (n - 1);
            }

            return n;
        }
    }
}
