package p1000_;

import java.util.List;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
 *
 * @author half-dead
 */
public class Puzzle524 {
    class Solution {
        public String findLongestWord(String s, List<String> d) {
            String result = "";
            for (String word : d) {
                if (isSubSequence(s, word)) {
                    if (word.length() > result.length()) result = word;
                    else if (word.length() == result.length() && word.compareTo(result) < 0) result = word;
                }
            }
            return result;
        }
        private boolean isSubSequence(String s1, String s2) {
            int from = 0;
            for (char c : s2.toCharArray())
                if ((from = s1.indexOf(c, from)) < 0) return false;
                else from++;
            return true;
        }
    }
}
