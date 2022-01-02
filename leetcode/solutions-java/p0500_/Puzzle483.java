package p0500_;

/**
 * https://leetcode.com/problems/smallest-good-base/
 *
 * @author half-dead
 */
public class Puzzle483 {

    class Solution {
        final String max = Long.toBinaryString(Long.MAX_VALUE);

        public String smallestGoodBase(String n) {
            long m = Long.parseLong(n);
            long lo = 2, hi = m - 1;
            while (lo < hi) {
                long mid = (lo + hi) / 2;
                if(isAllOne(m,mid)){

                } else {

                }
            }
            return "";
        }

        boolean isAllOne(long n, long base) {
            while (n > 0) {
                if (n % base != 1) return false;
                n /= base;
            }
            return true;
        }
    }
}
