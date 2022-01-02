package p1500_;

/**
 * https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 *
 * @author half-dead
 */
public class Puzzle1309 {
    class Solution {
        public String freqAlphabets(String s) {
            StringBuilder builder = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (c == '#') {
                    builder.append((char) ('a' - 1 + Integer.parseInt(s.substring(i - 2, i))));
                    i -= 2;
                } else {
                    builder.append((char) ('a' + (c - '1')));
                }
            }
            return builder.reverse().toString();
        }
    }
}
