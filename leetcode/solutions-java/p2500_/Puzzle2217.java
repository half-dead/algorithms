package p2500_;

/**
 * https://leetcode.com/problems/find-palindrome-with-fixed-length/
 *
 * @author half-dead
 */
public class Puzzle2217 {

    class Solution {
        public long[] kthPalindrome(int[] queries, int k) {
            int n = queries.length, half = (k + 1) / 2, lo = 1, hi = 9;
            while (half > 1) {
                lo *= 10;
                hi = hi * 10 + 9;
                half--;
            }
            int max = hi - lo + 1;

            long[] res = new long[n];
            for (int i = 0; i < n; i++) {
                if (queries[i] > max) {
                    res[i] = -1;
                } else {
                    res[i] = gen(lo + queries[i] - 1, k);
                }
            }
            return res;
        }

        long gen(int base, int k) {
            long res = base;
            if (k % 2 != 0) base /= 10;
            while (base > 0) {
                res = res * 10 + (base % 10);
                base /= 10;
            }
            return res;
        }
    }
}
