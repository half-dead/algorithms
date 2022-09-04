package p2500_;

/**
 * https://leetcode.com/problems/removing-stars-from-a-string/
 *
 * @author half-dead
 */
public class Puzzle2390 {

    class Solution {
        public String removeStars(String s) {
            char[] cs = s.toCharArray();
            int n = cs.length, lo = 0, hi = 0;
            while (hi < n) {
                if (cs[hi] != '*') {
                    cs[lo++] = cs[hi];
                } else {
                    lo--;
                }
                hi++;
            }
            return new String(cs, 0, lo);
        }
    }
}
