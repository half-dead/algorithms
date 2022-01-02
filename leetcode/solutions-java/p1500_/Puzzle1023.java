package p1500_;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/camelcase-matching/
 *
 * @author half-dead
 */
public class Puzzle1023 {
    class Solution {
        public List<Boolean> camelMatch(String[] queries, String pattern) {
            return Arrays.stream(queries).map(q -> match(q, pattern)).collect(Collectors.toList());
        }

        boolean match(String q, String p) {
            int i = 0, plen = p.length();
            for (char c : q.toCharArray())
                if (i < plen && c == p.charAt(i)) i++;
                else if (c < 'a' || c > 'z') return false;
            return i == p.length();
        }
    }
}
