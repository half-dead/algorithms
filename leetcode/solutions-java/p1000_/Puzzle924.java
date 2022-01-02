package p1000_;

import java.util.*;

/**
 * https://leetcode.com/problems/minimize-malware-spread/
 *
 * @author half-dead
 */
public class Puzzle924 {

    class Solution {
        public int minMalwareSpread(int[][] graph, int[] initial) {
            int n = graph.length, res = n - 1, max = 0;

            boolean[] malwares = new boolean[n], visited = new boolean[n];
            for (int node : initial) {
                res = Math.min(res, node);
                malwares[node] = true;
            }

            Map<Integer, List<Integer>> g = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (graph[i][j] == 1) {
                        g.computeIfAbsent(i, x -> new ArrayList<>()).add(j);
                        g.computeIfAbsent(j, x -> new ArrayList<>()).add(i);
                    }
                }
            }

            Arrays.sort(initial);
            for (int node : initial) {
                if (visited[node]) continue;

                int[] holder = new int[2];
                dfs(node, malwares, visited, g, holder);
                if (holder[0] == 1 && holder[1] > max) {
                    res = node;
                    max = holder[1];
                }
            }
            return res;
        }

        void dfs(int node, boolean[] malwares, boolean[] v, Map<Integer, List<Integer>> g, int[] holder) {
            if (v[node]) return;

            v[node] = true;
            holder[1]++;
            if (malwares[node]) holder[0]++;

            List<Integer> list = g.get(node);
            if (list == null) return;

            for (int next : list) dfs(next, malwares, v, g, holder);
        }
    }
}
