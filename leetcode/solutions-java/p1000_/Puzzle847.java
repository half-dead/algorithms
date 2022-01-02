package p1000_;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/shortest-path-visiting-all-nodes/
 *
 * @author half-dead
 */
public class Puzzle847 {

    public static void main(String[] args) {
        Solution s = new Puzzle847().new Solution();
        System.out.println(s.shortestPathLength(new int[][]{{1, 2, 3}, {0}, {0}, {0}}));
        System.out.println(s.shortestPathLength(new int[][]{{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}}));
    }

    class Solution {
        public int shortestPathLength(int[][] graph) {
            int n = graph.length, res = Integer.MAX_VALUE;

            int[][] dp = new int[n][1 << n];
            Deque<int[]> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
                dp[i][1 << i] = 0;
                q.addLast(new int[]{i, 1 << i});
            }

            while (!q.isEmpty()) {
                int[] prev = q.pollFirst();
                int node = prev[0], state = prev[1];

                for (int next : graph[node]) {
                    int nextState = state | (1 << next);
                    if (dp[next][nextState] < 0) {
                        dp[next][nextState] = dp[node][state] + 1;
                        q.offerLast(new int[]{next, nextState});
                    }
                }
            }

            for (int i = 0, m = (1 << n) - 1; i < n; i++) {
                res = Math.min(res, dp[i][m]);
            }
            return res;
        }
    }
}
