package p0500_;

// Given an integer n, return the number of trailing zeroes in n!.
// Note: Your solution should be in logarithmic time complexity.

/**
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 */
public class Puzzle172_FactorialTrailingZeros {
    public static void main(String[] args) {
        Puzzle172_FactorialTrailingZeros p = new Puzzle172_FactorialTrailingZeros();
        Solution solution = p.new Solution();
    }

    public class Solution {
        public int trailingZeroes(int n) {
            int num = 0;
            while (n > 0) {
                num += n / 5;
                n /= 5;
            }
            return num;
        }
    }
}
