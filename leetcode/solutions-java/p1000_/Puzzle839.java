package p1000_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/similar-string-groups/
 *
 * @author half-dead
 */
public class Puzzle839 {

    public static void main(String[] args) {
        Solution s = new Puzzle839().new Solution();
        System.out.println(s.numSimilarGroups(new String[]{"tars", "rats", "arts", "star"}));
    }

    class Solution {
        public int numSimilarGroups(String[] strs) {
            int n = strs.length, group = 0;
            Map<Integer, Set<Integer>> g = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (similar(strs[i], strs[j])) {
                        g.computeIfAbsent(i, x -> new HashSet<>()).add(j);
                        g.computeIfAbsent(j, x -> new HashSet<>()).add(i);
                    }
                }
            }

            Set<Integer> visit = new HashSet<>(n);
            for (int i = 0; i < n; i++) {
                if (visit.contains(i)) continue;
                dfs(g, i, visit);
                group++;
            }
            return group;
        }

        void dfs(Map<Integer, Set<Integer>> g, int i, Set<Integer> v) {
            if (!v.add(i)) return;

            Set<Integer> nexts = g.get(i);
            if (nexts != null) {
                for (int next : nexts) dfs(g, next, v);
            }
        }

        boolean similar(String a, String b) {
            int d = 0, n = a.length();
            for (int i = 0; i < n; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    if (d++ == 2) break;
                }
            }
            return d == 0 || d == 2;
        }
    }
}
