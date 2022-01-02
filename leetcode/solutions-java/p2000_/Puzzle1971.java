package p2000_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-if-path-exists-in-graph/
 *
 * @author half-dead
 */
public class Puzzle1971 {

    // union find
    class Solution {
        int[] dsu;

        public boolean validPath(int n, int[][] edges, int start, int end) {
            dsu = new int[n];
            for (int i = 0; i < n; i++) dsu[i] = i;

            for (int[] e : edges) {
                union(e[0], e[1]);
            }

            return find(start) == find(end);
        }

        void union(int x, int y) {
            int rx = find(x), ry = find(y);
            dsu[rx] = ry;
        }

        int find(int x) {
            while (x != dsu[x]) {
                dsu[x] = find(dsu[x]);
                x = dsu[x];
            }
            return x;
        }
    }

    // DFS, two fucking slow because test case is biased
    class DfsSolution {
        public boolean validPath(int n, int[][] edges, int start, int end) {
            boolean[] visited = new boolean[n];
            Map<Integer, List<Integer>> g = new HashMap<>(n);
            for (int[] e : edges) {
                g.computeIfAbsent(e[0], x -> new ArrayList<>()).add(e[1]);
                g.computeIfAbsent(e[1], x -> new ArrayList<>()).add(e[0]);
            }
            return dfs(g, visited, end, start);
        }

        boolean dfs(Map<Integer, List<Integer>> g, boolean[] visited, int end, int i) {
            if (i == end) return true;
            if (visited[i]) return false;
            visited[i] = true;
            for (int j : g.get(i)) {
                if (dfs(g, visited, end, j)) return true;
            }
            return false;
        }
    }
}
