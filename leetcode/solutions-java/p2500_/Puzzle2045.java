package p2500_;

import java.util.*;

/**
 * https://leetcode.com/problems/second-minimum-time-to-reach-destination/
 *
 * @author half-dead
 */
public class Puzzle2045 {

    class Solution1 {
        public int secondMinimum(int n, int[][] edges, int time, int change) {
            List<List<Integer>> g = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
            for (int[] e : edges) {
                g.get(e[0]).add(e[1]);
                g.get(e[1]).add(e[0]);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[]{1, 0, 0});

            int[][] visited = new int[n + 1][2];
            for (int i = 1; i <= n; i++) visited[i] = new int[]{-1, -1};

            while (pq.size() > 0) {
                int[] top = pq.poll();
                int v = top[0], reach = top[1], leave = top[2];

                int nr = leave + time, nl = nr, round = nl / change;
                if (round % 2 != 0) nl = (round + 1) * change;

                if (visited[v][0] == -1) {
                    visited[v][0] = reach;
                } else if (reach > visited[v][0] && visited[v][1] == -1) {
                    visited[v][1] = reach;
                } else continue;

                for (int next : g.get(v)) pq.offer(new int[]{next, nr, nl});
            }
            return visited[n][1];
        }
    }

    class Solution {
        public int secondMinimum(int n, int[][] edges, int time, int change) {
            List<List<Integer>> g = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
            for (int[] e : edges) {
                g.get(e[0]).add(e[1]);
                g.get(e[1]).add(e[0]);
            }

            int[][] minSteps = new int[n + 1][2];
            for (int i = 0; i <= n; i++) Arrays.fill(minSteps[i], Integer.MAX_VALUE);
            minSteps[1][0] = 0;

            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{1, 0});
            while (minSteps[n][1] == Integer.MAX_VALUE) {
                int[] top = q.poll();
                int node = top[0], step = top[1];

                for (int next : g.get(node)) {
                    if (step + 1 < minSteps[next][0]) {
                        minSteps[next][0] = step + 1;
                        q.offer(new int[]{next, step + 1});
                    } else if (step + 1 > minSteps[next][0] && step + 1 < minSteps[next][1]) {
                        minSteps[next][1] = step + 1;
                        q.offer(new int[]{next, step + 1});
                    }
                }
            }

            int ret = 0;
            for (int i = 0; i < minSteps[n][1]; i++) {
                if (ret % (2 * change) >= change) {
                    ret = ret + (2 * change - ret % (2 * change));
                }
                ret = ret + time;
            }
            return ret;
        }
    }
}
