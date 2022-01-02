package p2000_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/
 *
 * @author half-dead
 */
public class Puzzle1625 {
    class Solution {
        public String findLexSmallestString(String s, int a, int b) {
            Set<String> seen = new HashSet<>();
            dfs(s, a, b, seen);
            String ans = s;
            for (String c : seen) {
                if (c.compareTo(ans) < 0) {
                    ans = c;
                }
            }
            return ans;
        }

        void dfs(String s, int a, int b, Set<String> seen) {
            if (!seen.add(s)) return;

            char[] cs1 = s.toCharArray();
            for (int i = 1; i < cs1.length; i += 2) {
                cs1[i] = (char) ('0' + (cs1[i] - '0' + a) % 10);
            }

            dfs(new String(cs1), a, b, seen);
            dfs(s.substring(s.length() - b) + s.substring(0, s.length() - b), a, b, seen);
        }
    }
}
