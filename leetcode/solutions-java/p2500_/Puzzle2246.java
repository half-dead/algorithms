package p2500_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-path-with-different-adjacent-characters/
 *
 * @author half-dead
 */
public class Puzzle2246 {

    // dfs
    class Solution {

        Map<Integer, Set<Integer>> g = new HashMap<>();
        String s;
        int res = 1;

        public int longestPath(int[] parent, String s) {
            this.s = s;

            for (int i = 0; i < parent.length; i++) {
                g.computeIfAbsent(parent[i], x -> new HashSet<>()).add(i);
            }

            dfs(0);
            return res;
        }

        public int dfs(int p) {
            Set<Integer> children = g.get(p);
            if (children == null) return 1;

            char pc = s.charAt(p);
            int first = 0, second = 0;

            for (int c : children) {
                int len = dfs(c);

                char cc = s.charAt(c);
                if (pc == cc) continue;

                if (len > first) {
                    second = first;
                    first = len;
                } else if (len > second) {
                    second = len;
                }
            }
            res = Math.max(res, first + second + 1);
            return first + 1;
        }
    }
}
