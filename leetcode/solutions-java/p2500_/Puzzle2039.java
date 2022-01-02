package p2500_;

import java.util.*;

/**
 * https://leetcode.com/problems/the-time-when-the-network-becomes-idle/
 *
 * @author half-dead
 */
public class Puzzle2039 {

    // BFS + simple math
    class Solution {
        public int networkBecomesIdle(int[][] edges, int[] patience) {
            int n = patience.length, step = 0;
            Map<Integer, Set<Integer>> g = new HashMap<>(n);
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                g.computeIfAbsent(u, x -> new HashSet<>()).add(v);
                g.computeIfAbsent(v, x -> new HashSet<>()).add(u);
            }


            boolean[] visited = new boolean[n];
            visited[0] = true;

            Deque<Integer> dq = new LinkedList<>();
            dq.addLast(0);

            int[] distances = new int[n];
            while (dq.size() > 0) {
                int size = dq.size();
                while (size-- > 0) {
                    int node = dq.pollFirst();
                    distances[node] = step;

                    Set<Integer> neighbors = g.get(node);
                    for (int next : neighbors) {
                        if (visited[next]) continue;

                        dq.addLast(next);
                        visited[next] = true;
                    }
                }
                step++;
            }

            int res = 0;
            for (int i = 1; i < n; i++) {
                int d = distances[i], p = patience[i];
                int last = (2 * d - 1) / p * p;
                res = Math.max(res, last + 2 * d + 1);
            }
            return res;
        }
    }
}
