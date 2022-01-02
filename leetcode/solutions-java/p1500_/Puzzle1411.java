package p1500_;

/**
 * https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/
 *
 * @author half-dead
 */
public class Puzzle1411 {
    class Solution {
        public int numOfWays(int n) {
            long n121 = 6, n123 = 6, nx121, nx123;
            int mod = 1000000007;
            while (--n > 0) {
                nx121 = n121 * 3 + n123 * 2;
                nx123 = n121 * 2 + n123 * 2;
                n121 = nx121 % mod;
                n123 = nx123 % mod;
            }
            return (int) (n121 + n123) % mod;
        }
    }
}
