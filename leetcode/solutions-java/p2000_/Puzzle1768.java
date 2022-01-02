package p2000_;

/**
 * https://leetcode.com/problems/merge-strings-alternately/
 *
 * @author half-dead
 */
public class Puzzle1768 {

    class Solution {
        public String mergeAlternately(String word1, String word2) {
            int min = Math.min(word1.length(), word2.length());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < min; i++) {
                sb.append(word1.charAt(i)).append(word2.charAt(i));
            }
            return sb.append(word1, min, word1.length()).append(word2, min, word2.length()).toString();
        }
    }
}
