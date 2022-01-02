package p2000_;

/**
 * https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
 *
 * @author half-dead
 */
public class Puzzle1876 {

    class Solution {
        public int countGoodSubstrings(String s) {

            char[] cs = s.toCharArray();
            int res = 0, n = cs.length;
            for (int i = 2; i < n; i++) {
                if (cs[i - 2] != cs[i - 1] && cs[i - 1] != cs[i] && cs[i - 2] != cs[i]) res++;
            }
            return res;

        }
    }
}
