package p1000_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/possible-bipartition/
 *
 * @author half-dead
 */
public class Puzzle886 {

    class Solution {
        public boolean possibleBipartition(int n, int[][] dislikes) {
            List<List<Integer>> graph = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
            for (int[] d : dislikes) {
                graph.get(d[0]).add(d[1]);
                graph.get(d[1]).add(d[0]);
            }
            int[] state = new int[n + 1];
            for (int i = 1; i <= n; i++) if (state[i] == 0 && !dfs(graph, state, i, 1)) return false;
            return true;
        }

        boolean dfs(List<List<Integer>> g, int[] state, int i, int color) {
            if (state[i] != 0) return state[i] == color;
            state[i] = color;
            for (int p : g.get(i)) if (!dfs(g, state, p, -color)) return false;
            return true;
        }
    }
}
