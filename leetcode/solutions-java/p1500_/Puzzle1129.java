package p1500_;

import util.Print;

import java.util.*;

/**
 * https://leetcode.com/problems/shortest-path-with-alternating-colors/
 *
 * @author half-dead
 */
public class Puzzle1129 {
    public static void main(String[] args) {
        Solution s = new Puzzle1129().new Solution();
        Print.pt(s.shortestAlternatingPaths(3, new int[][]{{0, 1}, {1, 2}}, new int[][]{}));
        Print.pt(s.shortestAlternatingPaths(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, new int[][]{{1, 2}, {2, 3}, {3, 1}}));
        Print.pt(s.shortestAlternatingPaths(5, new int[][]{{2, 2}, {0, 4}, {4, 2}, {4, 3}, {2, 4}, {0, 0}, {0, 1}, {2, 3}, {1, 3}}, new int[][]{{0, 4}, {1, 0}, {1, 4}, {0, 0}, {4, 0}}));
    }

    class Solution {
        public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            Map<Integer, List<Integer>> red = new HashMap<>(), blue = new HashMap<>();
            for (int[] edge : redEdges) red.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            for (int[] edge : blueEdges) blue.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);

            int[] rv = new int[n], bv = new int[n];
            Arrays.fill(rv, -1);
            Arrays.fill(bv, -1);

            LinkedList<Integer> q = new LinkedList<>();
            q.offer(0);
            bfs(red, blue, q, 0, rv, bv, true);

            q = new LinkedList<>();
            q.offer(0);
            bfs(red, blue, q, 0, rv, bv, false);

            for (int i = 0; i < n; i++) {
                if (rv[i] >= 0 && bv[i] >= 0) rv[i] = Math.min(rv[i], bv[i]);
                else if (bv[i] >= 0) rv[i] = bv[i];
            }
            return rv;
        }

        void bfs(Map<Integer, List<Integer>> rmap, Map<Integer, List<Integer>> bmap, LinkedList<Integer> q, int path, int[] rv, int[] bv, boolean isRed) {
            if (q.isEmpty()) return;

            int i = q.size();
            while (i-- > 0) {
                int node = q.poll();

                int[] v = isRed ? rv : bv, nv = isRed ? bv : rv;
                if (v[node] < 0 || path < v[node]) v[node] = path;

                List<Integer> neighbours = isRed ? rmap.get(node) : bmap.get(node);
                if (neighbours == null) continue;

                for (int neighbour : neighbours) if (nv[neighbour] < 0 || path < nv[neighbour]) q.offer(neighbour);
            }
            bfs(rmap, bmap, q, path + 1, rv, bv, !isRed);
        }
    }
}
