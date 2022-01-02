package p2500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-common-words-with-one-occurrence/
 *
 * @author half-dead
 */
public class Puzzle2085 {

    class Solution {
        public int countWords(String[] words1, String[] words2) {
            Map<String, Integer> a = new HashMap<>(), b = new HashMap<>();
            for (String w : words1) a.put(w, a.getOrDefault(w, 0) + 1);
            for (String w : words2) b.put(w, b.getOrDefault(w, 0) + 1);

            int res = 0;
            for (String key : a.keySet()) {
                if (a.get(key) == 1 && b.getOrDefault(key, 0) == 1) res++;
            }
            return res;
        }
    }
}
