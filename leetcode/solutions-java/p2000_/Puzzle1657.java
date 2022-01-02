package p2000_;

import java.util.Arrays;

/**
 * @author half-dead
 */
public class Puzzle1657 {

    class Solution {
        public boolean closeStrings(String word1, String word2) {
            if (word1.length() != word2.length()) {
                return false;
            }

            int[] c1 = new int[26], c2 = new int[26];
            for (int i = 0; i < word1.length(); i++) {
                c1[word1.charAt(i) - 'a']++;
                c2[word2.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (c1[i] + c2[i] > 0 && c1[i] * c2[i] == 0) {
                    return false;
                }
            }
            Arrays.sort(c1);
            Arrays.sort(c2);
            for (int i = 0; i < 26; i++) {
                if (c1[i] != c2[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
