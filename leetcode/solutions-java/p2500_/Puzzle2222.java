package p2500_;

/**
 * https://leetcode.com/problems/number-of-ways-to-select-buildings/submissions/
 *
 * @author half-dead
 */
public class Puzzle2222 {

    // O(N) time, try 010 and 101
    class Solution {
        public long numberOfWays(String s) {
            char[] cs = s.toCharArray();

            int zeros = 0;
            for (char c : cs) if (c == '0') zeros++;
            int n = cs.length, ones = n - zeros;

            long res = 0L;
            for (int i = 0, lz = 0, lo = 0; i < n; i++) {
                if (cs[i] == '0') {
                    res += (long) lo * (ones - lo);
                    lz++;
                } else {
                    res += (long) lz * (zeros - lz);
                    lo++;
                }
            }
            return res;
        }
    }
}
