package p1500_;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 *
 * @author half-dead
 */
public class Puzzle1466 {

    // consider the roads bi-directional
    // start bfs from city 0
    // if we reach a city by a road that originally exists, we need to reorient this road
    class Solution {
        public int minReorder(int n, int[][] connections) {
            Map<Integer, Map<Integer, Integer>> g = new HashMap<>(n);
            for (int[] conn : connections) {
                g.computeIfAbsent(conn[0], x -> new HashMap<>()).put(conn[1], 1);
                g.computeIfAbsent(conn[1], x -> new HashMap<>()).put(conn[0], 0);
            }

            boolean[] visited = new boolean[n];
            visited[0] = true;

            Deque<Integer> q = new LinkedList<>();
            q.addLast(0);

            int res = 0;
            while (q.size() > 0) {
                int size = q.size();
                while (size-- > 0) {
                    int city = q.pollFirst();
                    Map<Integer, Integer> nei = g.get(city);
                    for (int next : nei.keySet()) {
                        if (visited[next]) continue;
                        q.addLast(next);
                        visited[next] = true;
                        res += nei.get(next);
                    }
                }
            }
            return res;
        }
    }
}
