package p2000_;

/**
 * https://leetcode.com/problems/minimum-non-zero-product-of-the-array-elements/
 *
 * @author half-dead
 */
public class Puzzle1969 {

    class Solution {
        public int minNonZeroProduct(int p) {
            int mod = (int) 1e9 + 7;
            long max = (1L << p) - 1, m = (max - 1) % mod, power = (max - 1) >> 1, res = 1L;
            while (power > 0) {
                if (power % 2 == 0) {
                    res = (res * res) % mod;
                    power >>= 1;
                } else {
                    res = (res * m) % mod;
                    power--;
                }
            }
            return (int) ((res * (max % mod)) % mod);
        }
    }
}
