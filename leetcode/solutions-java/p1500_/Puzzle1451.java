package p1500_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/rearrange-words-in-a-sentence/
 *
 * @author half-dead
 */
public class Puzzle1451 {

    class Solution {
        public String arrangeWords(String text) {
            String[] words = text.split(" ");
            words[0] = words[0].toLowerCase();
            Arrays.sort(words, Comparator.comparingInt(String::length));
            StringBuilder sb = new StringBuilder(text.length());
            for (String word : words) {
                if (sb.length() > 0) sb.append(' ');
                sb.append(word);
            }
            sb.setCharAt(0, (char) (sb.charAt(0) - 32));
            return sb.toString();
        }
    }
}
