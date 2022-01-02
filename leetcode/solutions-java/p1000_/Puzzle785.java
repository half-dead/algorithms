package p1000_;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * https://leetcode.com/problems/is-graph-bipartite/
 *
 * @author half-dead
 */
public class Puzzle785 {
    public static void main(String[] args) {
        Solution s = new Puzzle785().new Solution();
        System.out.println(s.isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
        System.out.println(s.isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
        System.out.println(s.isBipartite(new int[][]{{4}, {}, {4}, {4}, {0, 2, 3}}));
        System.out.println(s.isBipartite(new int[][]{{}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {1, 2, 8, 9}, {6, 9}, {1, 5, 7, 8, 9}, {3, 6, 9}, {2, 3, 4, 6, 9}, {2, 4, 5, 6, 7, 8}}));
        System.out.println(s.isBipartite(new int[][]{{1}, {0, 3}, {3}, {1, 2}}));
        System.out.println(s.isBipartite(new int[][]{{3}, {2, 4}, {1}, {0, 4}, {1, 3}}));
    }

    // bfs
    class Solution {
        public boolean isBipartite(int[][] graph) {
            int len = graph.length;
            int[] colors = new int[len];

            for (int i = 0; i < len; i++) {
                if (colors[i] != 0) continue;
                colors[i] = 1;

                LinkedList<Integer> q = new LinkedList<>();
                q.offer(i);
                while (q.size() > 0) {
                    int node = q.poll(), color = colors[node];
                    for (int neighbour : graph[node]) {
                        if (colors[neighbour] == 0) {
                            colors[neighbour] = -color;
                            q.offer(neighbour);
                        } else if (colors[neighbour] == color)
                            return false;
                    }
                }
            }
            return true;
        }
    }

    // dfs
    class DfsSolution {
        public boolean isBipartite(int[][] graph) {
            int len = graph.length;
            int[] colors = new int[len];

            for (int i = 0; i < len; i++)
                if (colors[i] == 0 && !paint(graph, colors, i, 1))
                    return false;
            return true;
        }

        boolean paint(int[][] graph, int[] colors, int node, int color) {
            if (colors[node] != 0) return colors[node] == color;

            colors[node] = color;
            for (int neighbour : graph[node])
                if (!paint(graph, colors, neighbour, -color))
                    return false;
            return true;
        }
    }

    // 3ms, a little complicated
    class MySolution {
        public boolean isBipartite(int[][] graph) {
            int len = graph.length;
            boolean[] state = new boolean[len];

            for (int i = 0; i < len; i++) {
                if (graph[i].length == 0) continue;
                if (state[i]) continue;

                Set<Integer> q1 = new HashSet<>(), q2 = new HashSet<>(), temp;
                LinkedList<Integer> q = new LinkedList<>();
                q.addLast(i);
                while (q.size() > 0) {
                    int j = q.size();
                    while (j-- > 0) {
                        int node = q.pollFirst();
                        if (state[node]) continue;

                        state[node] = true;
                        if (q2.contains(node)) return false;
                        q1.add(node);

                        for (int neighbour : graph[node]) {
                            if (q1.contains(neighbour)) return false;
                            if (state[neighbour]) continue;
                            q2.add(neighbour);
                            q.addLast(neighbour);
                        }
                    }
                    temp = q1;
                    q1 = q2;
                    q2 = temp;
                }
            }
            return true;
        }
    }
}
