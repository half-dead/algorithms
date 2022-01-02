package p1000_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/word-subsets/
 *
 * @author half-dead
 */
public class Puzzle916 {
    class Solution {
        public List<String> wordSubsets(String[] a, String[] b) {
            int[] count = new int[26], temp = new int[26];
            for (String word : b) {
                Arrays.fill(temp, 0);
                for (char c : word.toCharArray()) temp[c - 'a']++;
                for (int i = 0; i < 26; i++) count[i] = Math.max(count[i], temp[i]);
            }

            int letters = 0;
            for (int n : count) letters += n;

            List<String> list = new ArrayList<>();
            for (String word : a) {
                System.arraycopy(count, 0, temp, 0, 26);
                int total = letters;
                for (char c : word.toCharArray()) if (temp[c - 'a']-- > 0) total--;
                if (total == 0) list.add(word);
            }
            return list;
        }
    }
}
