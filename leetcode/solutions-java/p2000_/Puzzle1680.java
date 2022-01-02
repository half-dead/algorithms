package p2000_;

/**
 * https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
 *
 * @author half-dead
 */
public class Puzzle1680 {

    class Solution {
        public int concatenatedBinary(int n) {
            int mod = 1000000007, i = 1;
            long t = 1L;
            int[] bits = new int[n + 1];
            bits[1] = 1;
            while (++i <= n) {
                bits[i] = bits[i >> 1] + 1;
                t = (t << bits[i]) + i;
                t %= mod;
            }
            return (int) t;
        }
    }
}
