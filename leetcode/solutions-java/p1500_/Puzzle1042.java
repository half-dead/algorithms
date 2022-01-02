package p1500_;

import util.Print;

import java.util.*;

/**
 * https://leetcode.com/problems/flower-planting-with-no-adjacent/
 *
 * @author half-dead
 */
public class Puzzle1042 {
    public static void main(String[] args) {
        Solution s = new Puzzle1042().new Solution();
        Print.pt(s.gardenNoAdj(3, new int[][]{{1, 2}, {2, 3}, {3, 1}}));
        Print.pt(s.gardenNoAdj(4, new int[][]{{1, 2}, {3, 4}}));
    }

    class Solution2 {
        public int[] gardenNoAdj(int n, int[][] paths) {
            int[] ans = new int[n];
            Arrays.fill(ans, 1);
            boolean done;
            do {
                done = true;
                for (int[] path : paths) {
                    int from = Math.min(path[0], path[1]);
                    int to = Math.max(path[0], path[1]);
                    if (ans[from - 1] == ans[to - 1]) {
                        done = false;
                        ans[to - 1] = ans[to - 1] == 4 ? 1 : ans[to - 1] + 1;
                    }
                }
            } while (!done);
            return ans;
        }
    }

    // Greedy
    class Solution {
        public int[] gardenNoAdj(int n, int[][] paths) {
            Map<Integer, List<Integer>> g = new HashMap<>(n);
            for (int[] path : paths) {
                g.computeIfAbsent(path[0] - 1, k -> new ArrayList<>()).add(path[1] - 1);
                g.computeIfAbsent(path[1] - 1, k -> new ArrayList<>()).add(path[0] - 1);
            }
            int[] res = new int[n];
            boolean[] colors = new boolean[5];
            for (int i = 0; i < n; i++) {
                List<Integer> neighbours = g.get(i);
                if (neighbours == null) {
                    res[i] = 1;
                    continue;
                }

                for (int neighbour : neighbours) colors[res[neighbour]] = true;
                for (int color = 4; color > 0; color--)
                    if (!colors[color]) {
                        res[i] = color;
                        break;
                    }
                Arrays.fill(colors, false);
            }
            return res;
        }
    }

    // BFS
    class BfsSolution {
        public int[] gardenNoAdj(int n, int[][] paths) {
            Map<Integer, List<Integer>> graph = new HashMap<>(n);
            for (int[] path : paths) {
                graph.computeIfAbsent(path[0], k -> new ArrayList<>()).add(path[1]);
                graph.computeIfAbsent(path[1], k -> new ArrayList<>()).add(path[0]);
            }
            int[] res = new int[n];
            for (int garden = 1; garden <= n; garden++) {
                if (res[garden - 1] != 0) continue;

                Queue<Integer> q = new LinkedList<>();
                q.offer(garden);
                while (q.size() > 0) {
                    for (int i = q.size(); i > 0; i--) {
                        int from = q.poll();
                        if (res[from - 1] != 0) continue;

                        List<Integer> neighbours = graph.get(from);
                        if (neighbours == null) {
                            res[from - 1] = 1;
                            continue;
                        }

                        for (int color = 1; color <= 4; color++) {
                            boolean taken = false;
                            for (int neighbour : neighbours) {
                                if (res[neighbour - 1] == color) {
                                    taken = true;
                                    break;
                                } else if (res[neighbour - 1] == 0) {
                                    q.offer(neighbour);
                                }
                            }
                            if (!taken) {
                                res[from - 1] = color;
                                break;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) if (res[i] == 0) res[i] = 1;
            return res;
        }
    }
}
