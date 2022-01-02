package p1000_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-and-replace-pattern/
 *
 * @author half-dead
 */
public class Puzzle890_FindAndReplacePattern {
    class Solution {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List<String> list = new ArrayList<>();
            for (String word : words) {
                if (match(word, pattern)) {
                    list.add(word);
                }
            }
            return list;
        }

        private boolean match(String word, String pattern) {
            if (word.length() != pattern.length()) {
                return false;
            }
            Map<Character, Character> map1 = new HashMap<>();
            Map<Character, Character> map2 = new HashMap<>();
            for (int i = 0; i < pattern.length(); i++) {
                char from = pattern.charAt(i);
                char to = word.charAt(i);
                if (map1.containsKey(from) && map2.containsKey(to)) {
                    if (map1.get(from) != to || map2.get(to) != from) {
                        return false;
                    }
                } else if (!map1.containsKey(from) && !map2.containsKey(to)) {
                    map1.put(from, to);
                    map2.put(to, from);
                } else {
                    return false;
                }
            }
            return true;
        }
    }

}
