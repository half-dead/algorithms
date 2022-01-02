package p2000_;

/**
 * https://leetcode.com/problems/truncate-sentence/
 *
 * @author half-dead
 */
public class Puzzle1816 {

    class Solution {
        public String truncateSentence(String s, int k) {
            for (int i = 0, len = s.length(); i < len; i++) {
                if (s.charAt(i) == ' ' && --k == 0)
                    return s.substring(0, i);
            }
            return s;
        }
    }
}
