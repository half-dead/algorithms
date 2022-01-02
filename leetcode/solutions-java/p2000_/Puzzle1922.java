package p2000_;

/**
 * https://leetcode.com/problems/count-good-numbers/
 *
 * @author half-dead
 */
public class Puzzle1922 {

    class Solution {
        public int countGoodNumbers(long n) {
            int mod = (int) 1e9 + 7;

            long[] pow = new long[64];
            pow[0] = 5;
            pow[1] = 20;
            for (int i = 2; i < 64; i++) pow[i] = (pow[i - 1] * pow[i - 1]) % mod;

            StringBuilder sb = new StringBuilder(Long.toBinaryString(n)).reverse();

            long x = 1L;
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '1') {
                    x = (x * pow[i]) % mod;
                }
            }
            return (int) x;
        }
    }
}
