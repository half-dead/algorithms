package p2500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/detonate-the-maximum-bombs/
 *
 * @author half-dead
 */
public class Puzzle2101 {

    class Solution {
        public int maximumDetonation(int[][] bombs) {
            int n = bombs.length, res = 1;
            List<List<Integer>> g = new ArrayList<>();
            for (int i = 0; i < n; i++) g.add(new ArrayList<>());

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    build(bombs, i, j, g);
                }
            }

            boolean[] reached = new boolean[n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(reached, false);
                dfs(i, g, reached);
                int cnt = 0;
                for (boolean b : reached) if (b) cnt++;
                res = Math.max(res, cnt);
            }
            return res;
        }

        void build(int[][] bombs, int i, int j, List<List<Integer>> g) {
            long x = bombs[i][0] - bombs[j][0];
            long y = bombs[i][1] - bombs[j][1];
            long d = x * x + y * y;
            if ((long) bombs[i][2] * bombs[i][2] >= d) {
                g.get(i).add(j);
            }
            if ((long) bombs[j][2] * bombs[j][2] >= d) {
                g.get(j).add(i);
            }
        }

        void dfs(int i, List<List<Integer>> g, boolean[] reached) {
            if (reached[i]) return;
            reached[i] = true;
            for (int next : g.get(i)) {
                dfs(next, g, reached);
            }
        }
    }
}
