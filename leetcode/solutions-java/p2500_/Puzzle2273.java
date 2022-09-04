package p2500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
 *
 * @author half-dead
 */
public class Puzzle2273 {

    class Solution {
        public List<String> removeAnagrams(String[] words) {
            List<String> result = new ArrayList<>();
            String prev = "";
            for (int i = 0; i < words.length; i++) {
                String hash = encode(words[i]);
                if (!hash.equals(prev)) {
                    prev = hash;
                    result.add(words[i]);
                }
            }
            return result;
        }

        String encode(String w) {
            char[] cs = w.toCharArray();
            Arrays.sort(cs);
            return new String(cs);
        }
    }
}
