package p2000_;

/**
 * https://leetcode.com/problems/maximum-number-of-removable-characters/
 *
 * @author half-dead
 */
public class Puzzle1898 {

    class Solution {
        public int maximumRemovals(String s, String p, int[] removable) {
            int lo = 0, hi = removable.length;
            char[] cs = s.toCharArray(), cp = p.toCharArray();
            while (lo < hi) {
                int mid = (lo + hi + 1) >> 1;
                if (check(cs, cp, mid, removable)) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            return lo;
        }

        boolean check(char[] cs, char[] cp, int k, int[] r) {
            boolean[] b = new boolean[cs.length];
            for (int i = 0; i < k; i++) {
                b[r[i]] = true;
            }
            int is = 0, ip = 0;
            while (is < cs.length && ip < cp.length) {
                if (!b[is] && cs[is] == cp[ip])
                    ip++;
                is++;
            }
            return ip == cp.length;
        }
    }
}
