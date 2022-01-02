package p2000_;

/**
 * https://leetcode.com/problems/count-number-of-homogenous-substrings/
 *
 * @author half-dead
 */
public class Puzzle1759 {

    // sum
    class Solution {
        public int countHomogenous(String s) {
            char[] cs = s.toCharArray();
            int i = 0, len = cs.length, mod = (int) 1e9 + 7, res = 0;
            while (i < len) {
                int j = i;
                while (j < len && cs[j] == cs[i]) {
                    res = (res + j++ - i + 1) % mod;
                }
                i = j;
            }
            return res;
        }
    }

    // multiple
    class Solution1 {
        public int countHomogenous(String s) {
            char[] cs = s.toCharArray();
            int i = 0, len = cs.length, mod = (int) 1e9 + 7;
            long res = 0L;
            while (i < len) {
                int j = i + 1;
                while (j < len && cs[j] == cs[i]) j++;

                int cnt = j - i;
                res = (res + (long) cnt * (cnt + 1) / 2) % mod;
                i = j;
            }
            return (int) res;
        }
    }
}
