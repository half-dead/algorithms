package p2500_;

/**
 * https://leetcode.com/problems/count-prefixes-of-a-given-string/
 *
 * @author half-dead
 */
public class Puzzle2255 {

    class Solution {
        public int countPrefixes(String[] words, String s) {
            int res = 0;
            for (String w : words) {
                if (s.indexOf(w) == 0) res++;
            }
            return res;
        }
    }
}
