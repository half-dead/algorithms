package p0500_;

// Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
// For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

/**
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class Puzzle191_NumberOf1Bits {

    public class Solution {
        public int hammingWeight(int n) {
//            if ((n & n - 1) == 0) return 1;
            int i = 0;
            while (n != 0) {
                if ((n & 1) == 1) {
                    i++;
                }
                n >>>= 1;
            }
            return i;
        }
    }

}
