package p2000_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
 *
 * @author half-dead
 */
public class Puzzle1519 {

    class Solution {
        Map<Integer, List<Integer>> g;
        char[] cs;
        int[][] memo;
        boolean[] seen;

        public int[] countSubTrees(int n, int[][] edges, String labels) {
            g = new HashMap<>(n);
            for (int[] edge : edges) {
                g.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
                g.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
            }
            cs = labels.toCharArray();
            memo = new int[n][26];
            seen = new boolean[n];
            dfs(0);
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = memo[i][cs[i] - 'a'];
            }
            return ans;
        }

        void dfs(int node) {
            seen[node] = true;

            List<Integer> children = g.get(node);
            if (children != null) {
                for (int child : children) {
                    if (seen[child]) continue;
                    dfs(child);
                    add(node, child);
                }
            }
            memo[node][cs[node] - 'a']++;
        }

        void add(int p, int c) {
            for (int i = 0; i < 26; i++) memo[p][i] += memo[c][i];
        }
    }
}
