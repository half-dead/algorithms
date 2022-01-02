package p2000_;

/**
 * https://leetcode.com/problems/maximal-network-rank/
 *
 * @author half-dead
 */
public class Puzzle1615 {
    class Solution {
        public int maximalNetworkRank(int n, int[][] roads) {
            boolean[][] b = new boolean[n][n];
            int[] cnt = new int[n];
            for (int[] r : roads) {
                b[r[0]][r[1]] = b[r[1]][r[0]] = true;
                cnt[r[0]]++;
                cnt[r[1]]++;
            }
            // find max and second-max
            int x = 0, y = 0, res = 0;
            for (int c : cnt) {
                if (c > x) {
                    y = x;
                    x = c;
                } else if (c > y) {
                    y = c;
                }
            }
            // brute-force
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (cnt[i] >= y && cnt[j] >= y) {
                        res = Math.max(res, cnt[i] + cnt[j] - (b[i][j] ? 1 : 0));
                    }
                }
            }
            return res;
        }
    }
}


