package p0500_;

// Reverse bits of a given 32 bits unsigned integer.
//
// For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
// return 964176192 (represented in binary as 00111001011110000010100101000000).
//
// Follow up:
// If this function is called many times, how would you optimize it?

/**
 * https://leetcode.com/problems/reverse-bits/
 */
public class Puzzle190_ReverseBits {
    public class Solution {
        public int reverseBits(int n) {
            int result = 0;
            int mask = 1, i = 0;
            while (i < 32) {
                result <<= 1;
                if ((n & (mask << i++)) != 0) {
                    result += 1;
                }
            }
            return result;
        }
    }
}
