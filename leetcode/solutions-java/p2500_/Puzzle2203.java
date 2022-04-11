package p2500_;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-weighted-subgraph-with-the-required-paths/
 *
 * @author half-dead
 */
public class Puzzle2203 {

    public static void main(String[] args) {
        Solution s = new Puzzle2203().new Solution();
        System.out.println(s.minimumWeight(6, new int[][]{
                {0, 2, 2}, {0, 5, 6}, {1, 0, 3}, {1, 4, 5}, {2, 1, 1}, {2, 3, 3}, {2, 3, 4}, {3, 4, 2}, {4, 5, 1}
        }, 0, 1, 5));
    }

    class Solution {
        public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
            Map<Integer, List<int[]>> g = new HashMap<>(), rg = new HashMap<>();
            for (int[] e : edges) {
                int u = e[0], v = e[1], w = e[2];
                g.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[]{v, w});
                rg.computeIfAbsent(v, x -> new ArrayList<>()).add(new int[]{u, w});
            }

            long[] dp1 = new long[n], dp2 = new long[n], dpd = new long[n];
            Arrays.fill(dp1, -1L);
            Arrays.fill(dp2, -1L);
            Arrays.fill(dpd, -1L);

            bfs(dest, rg, n, dpd);
            if (dpd[src1] < 0 || dpd[src2] < 0) return -1;

            bfs(src1, g, n, dp1);
            bfs(src2, g, n, dp2);

            long res = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (dp1[i] < 0 || dp2[i] < 0) continue;
                res = Math.min(res, dp1[i] + dp2[i] + dpd[i]);
            }
            return res;
        }

        void bfs(int start, Map<Integer, List<int[]>> g, int n, long[] dp) {
            PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
            pq.offer(new long[]{start, 0L});

            boolean[] v = new boolean[n];

            while (pq.size() > 0) {
                long[] top = pq.poll();
                int node = (int) top[0];
                long wsum = top[1];
                if (dp[node] < 0) {
                    dp[node] = wsum;
                } else continue;

                v[node] = true;

                List<int[]> nexts = g.get(node);
                if (nexts == null) continue;

                for (int[] next : nexts) {
                    if (v[next[0]]) continue;
                    pq.offer(new long[]{next[0], wsum + next[1]});
                }
            }
        }
    }
}
