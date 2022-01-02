package p1000_;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author half-dead
 */
public class Puzzle802 {
    public static void main(String[] args) {
        Solution s = new Puzzle802().new Solution();
        System.out.println(s.eventualSafeNodes(new int[][]{{1}, {2}, {3}, {4}, {0}, {6}, {}}));
    }


    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            int[] state = new int[n];
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++)
                if (dfs(graph, state, i))
                    res.add(i);
            return res;
        }

        private boolean dfs(int[][] graph, int[] state, int i) {
            if (state[i] != 0) return state[i] == 1;

            state[i] = -1;
            for (int n : graph[i])
                if (!dfs(graph, state, n))
                    return false;

            state[i] = 1;
            return true;
        }
    }

    // without returning-value
    class Solution1 {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            int[] state = new int[n];
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                dfs(graph, state, i);
                if (state[i] != -1)
                    res.add(i);
            }
            return res;
        }

        void dfs(int[][] graph, int[] state, int i) {
            if (state[i] != 0) return;

            state[i] = -1;
            for (int n : graph[i]) {
                dfs(graph, state, n);
                if (state[n] == -1)
                    return;
            }
            state[i] = 1;
        }
    }

    class Solution2 {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            int[] state = new int[n];
            Set<Integer> path = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (state[i] == 0) dfs(graph, i, state, path);
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) if (state[i] > 0) list.add(i);
            return list;
        }

        void dfs(int[][] g, int start, int[] state, Set<Integer> path) {
            path.add(start);
            state[start] = 1;
            for (int neighbour : g[start]) {
                if (state[neighbour] == 0) {
                    dfs(g, neighbour, state, path);
                } else if (state[neighbour] == -1 || path.contains(neighbour)) {
                    for (int p : path) state[p] = -1;
                }
            }
            path.remove(start);
        }
    }
}
