package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/redundant-connection-ii/
 *
 * @author half-dead
 */
public class Puzzle685_RedundantConnectionII {

    public static void main(String[] args) {
        Puzzle685_RedundantConnectionII p = new Puzzle685_RedundantConnectionII();
        Solution s = p.new Solution();
        int[] r = s.findRedundantDirectedConnection(new int[][]{
//                {1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}
                {1, 2}, {1, 3}, {2, 3}
        });
        System.out.println(Arrays.toString(r));
    }

    class Solution {
        int[] dsu;

        public int[] findRedundantDirectedConnection(int[][] edges) {
            dsu = new int[edges.length + 1];

            boolean flag = false;
            int p1 = 0, p2 = 0, c = 0;
            for (int[] edge : edges) {
                if (dsu[edge[1]] == 0) {
                    dsu[edge[1]] = edge[0];
                } else {
                    flag = true;
                    p1 = dsu[edge[1]];
                    p2 = edge[0];
                    c = edge[1];
                    break;
                }
            }

            for (int i = 0; i < dsu.length; i++) {
                dsu[i] = i;
            }

            for (int[] edge : edges) {
                // if a node has two parents, delete the second occured edge.
                if (!flag || edge[0] != p2 || edge[1] != c) {
                    if (!union(edge[0], edge[1])) {
                        return flag ? new int[]{p1, c} : edge;
                    }
                }
            }
            return new int[]{p2, c};
        }

        private boolean union(int p, int c) {
            int pr = find(p), cr = find(c);
            if (pr == cr) {
                return false;
            }
            dsu[cr] = pr;
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
