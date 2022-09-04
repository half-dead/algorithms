package p2500_;

/**
 * https://leetcode.com/problems/decode-the-message/
 *
 * @author half-dead
 */
public class Puzzle2325 {

    class Solution {
        public String decodeMessage(String key, String message) {
            int[] idx = new int[26];
            int seq = 0;
            for (char c : key.toCharArray()) {
                if (c == ' ') continue;
                int pos = c - 'a';
                if (idx[pos] == 0) {
                    idx[pos] = ++seq;
                }
            }

            char[] cs = message.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                if (cs[i] == ' ') continue;
                cs[i] = (char) ('a' + idx[cs[i] - 'a'] - 1);
            }
            return new String(cs);
        }
    }
}
