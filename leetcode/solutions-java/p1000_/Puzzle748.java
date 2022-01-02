package p1000_;

/**
 * Shortest Completing Word
 * https://leetcode.com/problems/shortest-completing-word/
 *
 * @author half-dead
 */
public class Puzzle748 {
    class Solution {
        public String shortestCompletingWord(String licensePlate, String[] words) {
            byte[] bytes = new byte[26];
            int count = 0;
            for (char c : licensePlate.toCharArray()) {
                if (c >= 'A' && c <= 'Z') c = Character.toLowerCase(c);
                if (c >= 'a' && c <= 'z') {
                    bytes[c - 'a']++;
                    count++;
                }
            }

            byte[] copy = new byte[26];
            int temp;
            String answer = null;
            for (String w : words) {
                temp = count;
                System.arraycopy(bytes, 0, copy, 0, 26);

                for (char c : w.toCharArray()) {
                    int idx = c - 'a';
                    if (copy[idx]-- > 0) {
                        if (--temp == 0 && (answer == null || answer.length() > w.length())) {
                            answer = w;
                            break;
                        }
                    }
                }
            }
            return answer;
        }
    }
}
