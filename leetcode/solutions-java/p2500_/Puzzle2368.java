package p2500_;

import util.UnionFind;

import java.util.*;

/**
 * https://leetcode.com/problems/reachable-nodes-with-restrictions/
 *
 * @author half-dead
 */
public class Puzzle2368 {

    class BFSSolution {
        public int reachableNodes(int n, int[][] edges, int[] restricted) {
            Map<Integer, Set<Integer>> g = new HashMap<>();
            for (int[] edge : edges) {
                int x = edge[0], y = edge[1];
                g.computeIfAbsent(x, o -> new HashSet<>()).add(y);
                g.computeIfAbsent(y, o -> new HashSet<>()).add(x);
            }

            boolean[] v = new boolean[n];
            for (int r : restricted) {
                v[r] = true;
            }

            int res = 0;
            Deque<Integer> dq = new LinkedList<>();
            dq.addLast(0);
            while (dq.size() > 0) {
                int size = dq.size();
                while (size-- > 0) {
                    int node = dq.pollFirst();
                    if (v[node]) continue;

                    res++;
                    v[node] = true;
                    Set<Integer> neighbours = g.get(node);
                    if (neighbours == null) continue;

                    for (int next : neighbours) {
                        if (v[next]) continue;
                        dq.addLast(next);
                    }
                }
            }
            return res;
        }
    }

    class Solution {
        public int reachableNodes(int n, int[][] edges, int[] restricted) {
            UnionFind uf = new UnionFind(n);
            boolean[] removed = new boolean[n];

            for (int r : restricted) {
                removed[r] = true;
            }

            for (int[] e : edges) {
                int x = e[0], y = e[1];
                if (removed[x] || removed[y]) continue;

                uf.union(x, y);
            }

            return uf.size(0);
        }
    }
}
