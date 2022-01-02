package p2000_;

/**
 * https://leetcode.com/problems/count-unhappy-friends/
 *
 * @author half-dead
 */
public class Puzzle1583 {

    // pre-calculation + simulation
    class Solution {
        public int unhappyFriends(int n, int[][] pfs, int[][] pairs) {
            int[][] ranks = new int[n][n];
            for (int i = 0; i < n; i++) {
                int[] pf = pfs[i];
                for (int j = 0; j < n - 1; j++) {
                    ranks[i][pf[j]] = j;
                }
            }

            // store pair relationships in ranks
            for (int[] p : pairs) {
                ranks[p[0]][p[0]] = p[1];
                ranks[p[1]][p[1]] = p[0];
            }

            int res = 0;
            for (int x = 0; x < n; x++) {
                int y = ranks[x][x];
                for (int u : pfs[x]) {
                    if (u == y) break;
                    int v = ranks[u][u];
                    if (ranks[u][x] < ranks[u][v]) {
                        res++;
                        break;
                    }
                }
            }
            return res;
        }
    }
}
