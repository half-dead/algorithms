package p2000_;

/**
 * https://leetcode.com/problems/decode-xored-permutation/
 *
 * @author half-dead
 */
public class Puzzle1734 {

    class Solution {
        public int[] decode(int[] encoded) {
            int n = encoded.length + 1, totalXor = 0, partialXor = 0;
            for (int i = 1; i <= n; i++) totalXor ^= i;
            for (int i = 1; i < encoded.length; i += 2) partialXor ^= encoded[i];

            int[] res = new int[n];
            res[0] = totalXor ^ partialXor;
            for (int i = 1; i < n; i++) res[i] = encoded[i - 1] ^ res[i - 1];
            return res;
        }
    }
}
