package p2500_;

import java.util.*;

/**
 * https://leetcode.com/problems/odd-string-difference/
 */
public class Puzzle2451 {
    class Solution {
        public String oddString(String[] words) {
            Map<String, List<String>> map = new HashMap<>();
            for (String word : words) {
                int d = word.charAt(0) - 'a';
                char[] cs = word.toCharArray();
                for (int i = 0; i < cs.length; i++) {
                    cs[i] -= d;
                }
                String encode = new String(cs);
                map.computeIfAbsent(encode, x -> new LinkedList<>()).add(word);
            }
            for (List<String> g : map.values()) {
                if (g.size() == 1) {
                    return g.iterator().next();
                }
            }
            return "";
        }
    }
}
