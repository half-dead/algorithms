package p2500_;

/**
 * https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/
 *
 * @author half-dead
 */
public class Puzzle2309 {
    class Solution {
        public String greatestLetter(String s) {
            boolean[] lower = new boolean[26];
            boolean[] upper = new boolean[26];
            for (char c : s.toCharArray()) {
                if (c >= 'a') {
                    lower[c - 'a'] = true;
                } else {
                    upper[c - 'A'] = true;
                }
            }

            for (int i = 25; i >= 0; i--) {
                if (lower[i] && upper[i]) {
                    return (char) ('A' + i) + "";
                }
            }
            return "";
        }
    }
}
