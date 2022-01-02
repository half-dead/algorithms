package p2000_;

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-reinitialize-a-permutation/
 *
 * @author half-dead
 */
public class Puzzle1806 {

    class Solution {
        public int reinitializePermutation(int n) {
            int half = n >> 1, i = 1, res = 0;
            while (res == 0 || i > 1) {
                if (i < half) {
                    i <<= 1;
                } else {
                    i = 1 + (i - half) * 2;
                }
                res++;
            }
            return res;
        }
    }
}
