package p1500_;

import java.util.*;

/**
 * https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 *
 * @author half-dead
 */
public class Puzzle1334 {

    public static void main(String[] args) {
        Solution s = new Puzzle1334().new Solution();
        System.out.println(s.findTheCity(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));
        System.out.println(s.findTheCity(5, new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2));
    }

    // floyd warshall
    class Solution {
        public int findTheCity(int n, int[][] edges, int dt) {
            int[][] dis = new int[n][n];
            int res = 0, smallest = n;
            for (int[] row : dis)
                Arrays.fill(row, 10001);
            for (int[] e : edges)
                dis[e[0]][e[1]] = dis[e[1]][e[0]] = e[2];
            for (int i = 0; i < n; ++i)
                dis[i][i] = 0;
            for (int k = 0; k < n; ++k)
                for (int i = 0; i < n; ++i)
                    for (int j = 0; j < n; ++j)
                        dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < n; ++j)
                    if (dis[i][j] <= dt)
                        ++count;
                if (count <= smallest) {
                    res = i;
                    smallest = count;
                }
            }
            return res;
        }
    }

    // dijkstra with out optimization
    class Solution1 {
        public int findTheCity(int n, int[][] edges, int dt) {
            Map<Integer, List<int[]>> g = new HashMap<>();
            for (int[] edge : edges) {
                g.computeIfAbsent(edge[0], (a) -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
                g.computeIfAbsent(edge[1], (a) -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
            }
            for (int i = n - 1; i >= 0; i--) {
                if (!g.containsKey(i)) {
                    return i;
                }
            }

            int min = Integer.MAX_VALUE, k = -1;
            for (int i = 0; i < n; i++) {
                if (!g.containsKey(i)) continue;

                PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
                q.offer(new int[]{i, 0});
                Set<Integer> seen = new HashSet<>();

                int cnt = 0;
                while (q.size() > 0) {
                    int[] currentCity = q.poll();
                    if (seen.add(currentCity[0])) {
                        cnt++;
                    }
                    List<int[]> neighbours = g.get(currentCity[0]);
                    for (int[] neighbour : neighbours) {
                        if (seen.contains(neighbour[0])) {
                            continue;
                        }

                        int dis = currentCity[1] + neighbour[1];
                        if (dis <= dt) {
                            q.offer(new int[]{neighbour[0], dis});
                        }
                    }
                }
                if (cnt < min || (cnt == min && i > k)) {
                    min = cnt;
                    k = i;
                }
            }
            return k;
        }
    }
}
