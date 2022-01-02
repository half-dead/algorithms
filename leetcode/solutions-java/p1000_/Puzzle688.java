package p1000_;

/**
 * https://leetcode.com/problems/knight-probability-in-chessboard/
 *
 * @author half-dead
 */
public class Puzzle688 {
    public static void main(String[] args) {
        Solution s = new Puzzle688().new Solution();
        System.out.println(s.knightProbability(3, 2, 0, 0));
    }

    class Solution {
        public double knightProbability(int n, int k, int r, int c) {
            int[][] moves = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
            double[][] dp = new double[n][n];
            dp[r][c] = 1.0d;
            while (k > 0) {
                double[][] next = new double[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (dp[i][j] > 0) {
                            for (int[] move : moves) {
                                int ni = i + move[0];
                                int nj = j + move[1];
                                if (ni >= 0 && nj >= 0 && ni < n && nj < n) {
                                    next[ni][nj] += dp[i][j] * 0.125d;
                                }
                            }
                        }
                    }
                }
                dp = next;
                k--;
            }
            double sum = 0;
            for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) if (dp[i][j] > 0) sum += dp[i][j];
            return sum;
        }
    }
}
