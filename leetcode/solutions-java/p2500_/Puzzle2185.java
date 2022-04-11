package p2500_;

/**
 * https://leetcode.com/problems/counting-words-with-a-given-prefix/
 *
 * @author half-dead
 */
public class Puzzle2185 {
    class Solution {
        public int prefixCount(String[] words, String pref) {
            int res = 0;
            for (String w : words) if (w.startsWith(pref)) res++;
            return res;
        }
    }
}
