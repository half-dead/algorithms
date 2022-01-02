package p1000_;

import java.util.*;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 *
 * @author half-dead
 */
public class Puzzle787 {
    public static void main(String[] args) {
        Solution s = new Puzzle787().new Solution();
//        System.out.println(s.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
        System.out.println(s.findCheapestPrice(17, new int[][]{
                {0, 12, 28}, {5, 6, 39}, {8, 6, 59}, {13, 15, 7}, {13, 12, 38}, {10, 12, 35}, {15, 3, 23}, {7, 11, 26}, {9, 4, 65}, {10, 2, 38}, {4, 7, 7}, {14, 15, 31}, {2, 12, 44}, {8, 10, 34}, {13, 6, 29}, {5, 14, 89}, {11, 16, 13}, {7, 3, 46}, {10, 15, 19}, {12, 4, 58}, {13, 16, 11}, {16, 4, 76}, {2, 0, 12}, {15, 0, 22}, {16, 12, 13}, {7, 1, 29}, {7, 14, 100}, {16, 1, 14}, {9, 6, 74}, {11, 1, 73}, {2, 11, 60}, {10, 11, 85}, {2, 5, 49}, {3, 4, 17}, {4, 9, 77}, {16, 3, 47}, {15, 6, 78}, {14, 1, 90}, {10, 5, 95}, {1, 11, 30}, {11, 0, 37}, {10, 4, 86}, {0, 8, 57}, {6, 14, 68}, {16, 8, 3}, {13, 0, 65}, {2, 13, 6}, {5, 13, 5}, {8, 11, 31}, {6, 10, 20}, {6, 2, 33}, {9, 1, 3}, {14, 9, 58}, {12, 3, 19}, {11, 2, 74}, {12, 14, 48}, {16, 11, 100}, {3, 12, 38}, {12, 13, 77}, {10, 9, 99}, {15, 13, 98}, {15, 12, 71}, {1, 4, 28}, {7, 0, 83}, {3, 5, 100}, {8, 9, 14}, {15, 11, 57}, {3, 6, 65}, {1, 3, 45}, {14, 7, 74}, {2, 10, 39}, {4, 8, 73}, {13, 5, 77}, {10, 0, 43}, {12, 9, 92}, {8, 2, 26}, {1, 7, 7}, {9, 12, 10}, {13, 11, 64}, {8, 13, 80}, {6, 12, 74}, {9, 7, 35}, {0, 15, 48}, {3, 7, 87}, {16, 9, 42}, {5, 16, 64}, {4, 5, 65}, {15, 14, 70}, {12, 0, 13}, {16, 14, 52}, {3, 10, 80}, {14, 11, 85}, {15, 2, 77}, {4, 11, 19}, {2, 7, 49}, {10, 7, 78}, {14, 6, 84}, {13, 7, 50}, {11, 6, 75}, {5, 10, 46}, {13, 8, 43}, {9, 10, 49}, {7, 12, 64}, {0, 10, 76}, {5, 9, 77}, {8, 3, 28}, {11, 9, 28}, {12, 16, 87}, {12, 6, 24}, {9, 15, 94}, {5, 7, 77}, {4, 10, 18}, {7, 2, 11}, {9, 5, 41}
        }, 13, 4, 13));

    }

    // Bellman ford
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            int[] dp = new int[n];
            Arrays.fill(dp, -1);
            dp[src] = 0;

            for (int i = 0; i <= k; i++) {
                int[] copy = Arrays.copyOf(dp, n);
                for (int[] f : flights) {
                    int from = f[0], to = f[1], price = f[2];
                    if (dp[from] < 0) continue;
                    copy[to] = copy[to] < 0 ? dp[from] + price : Math.min(copy[to], dp[from] + price);
                }
                dp = copy;
            }
            return dp[dst];
        }
    }

    // Dijkstra
    class DijkstraSolution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            int[][] graph = new int[n][n];
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int[] flight : flights) {
                graph[flight[0]][flight[1]] = flight[2];
                map.computeIfAbsent(flight[0], (key) -> new ArrayList<>()).add(flight[1]);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[0]));
            pq.offer(new int[]{0, src, k + 1});
            while (!pq.isEmpty()) {
                int[] top = pq.poll();
                int cost = top[0], city = top[1], stops = top[2];
                if (city == dst) return cost;
                if (stops <= 0) continue;

                List<Integer> neighbours = map.get(city);
                if (neighbours == null) continue;
                for (int to : neighbours)
                    pq.offer(new int[]{cost + graph[city][to], to, stops - 1});
            }
            return -1;
        }
    }

    // Dp, O(K * N^2) time
    class DpSolution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            int[][] graph = new int[n][n];
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int[] flight : flights) {
                graph[flight[0]][flight[1]] = flight[2];
                map.computeIfAbsent(flight[0], (key) -> new HashSet<>()).add(flight[1]);
            }

            int[][] dp = new int[k + 2][n];
            for (int[] row : dp) Arrays.fill(row, -1);
            dp[0][src] = 0;
            for (int stop = 0; stop <= k; stop++) {
                int next = stop + 1;
                for (int from = 0; from < n; from++) {
                    int cost = dp[stop][from];
                    if (cost < 0) continue;

                    Set<Integer> set = map.get(from);
                    if (set == null) continue;

                    for (int to : set) {
                        if (dp[next][to] == -1) {
                            dp[next][to] = cost + graph[from][to];
                        } else {
                            dp[next][to] = Math.min(dp[next][to], cost + graph[from][to]);
                        }
                    }
                }
            }
            boolean found = false;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < k + 2; i++) {
                if (dp[i][dst] > 0) {
                    found = true;
                    min = Math.min(min, dp[i][dst]);
                }
            }
            return found ? min : -1;
        }
    }

}
