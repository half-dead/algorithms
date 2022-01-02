package p1000_;

import java.util.*;

/**
 * https://leetcode.com/problems/redundant-connection/
 *
 * @author half-dead
 */
public class Puzzle684_RedundantConnection {

    public static void main(String[] args) {
        Puzzle684_RedundantConnection p = new Puzzle684_RedundantConnection();
        Solution s = p.new Solution();
        int[] r = s.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}});
        System.out.println(Arrays.toString(r));
    }

    class DfsSolution {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        public int[] findRedundantConnection(int[][] edges) {
            for (int[] edge : edges) {
                map.putIfAbsent(edge[0], new HashSet<>());
                map.get(edge[0]).add(edge[1]);
                map.putIfAbsent(edge[1], new HashSet<>());
                map.get(edge[1]).add(edge[0]);
            }

            int[] res = null;
            for (int i = edges.length - 1; i >= 0; i--) {
                int u = edges[i][0];
                int v = edges[i][1];
                Set<Integer> us = map.get(u);
                Set<Integer> vs = map.get(v);
                if (us.size() > 1 && vs.size() > 1) {
                    us.remove(v);
                    vs.remove(u);
                    if (dfs(u, v, new HashSet<>())) {
                        res = new int[]{Math.min(u, v), Math.max(u, v)};
                        break;
                    }
                    us.add(v);
                    vs.add(u);
                }
            }
            return res;
        }

        private boolean dfs(int u, int v, Set<Integer> visited) {
            if (!visited.contains(u)) {
                visited.add(u);
                Set<Integer> dests = map.get(u);
                if (dests.contains(v)) {
                    return true;
                }
                for (int dest : dests) {
                    if (dfs(dest, v, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    class Solution {
        int[] dsu;
        int[] rank;

        public int[] findRedundantConnection(int[][] edges) {
            rank = new int[edges.length + 1];
            dsu = new int[edges.length + 1];
            for (int i = 0; i < dsu.length; i++) {
                dsu[i] = i;
            }
            for (int[] edge : edges) {
                boolean b = union(edge[0], edge[1]);
                if (!b) {
                    return edge;
                }
            }
            return null;
        }

        private boolean union(int x, int y) {
            int xx = find(x), yy = find(y);
            if (xx == yy) {
                return false;
            }
            if (rank[xx] < rank[yy]) {
                dsu[xx] = yy;
            } else if (rank[xx] > rank[yy]) {
                dsu[yy] = xx;
            } else {
                rank[xx]++;
                dsu[yy] = xx;
            }
            return true;
        }

        private int find(int x) {
            if (dsu[x] != x) {
                dsu[x] = find(dsu[x]);
            }
            return dsu[x];
        }
    }

}
