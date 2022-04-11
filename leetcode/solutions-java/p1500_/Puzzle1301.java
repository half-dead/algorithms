package p1500_;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/number-of-paths-with-max-score/
 *
 * @author half-dead
 */
public class Puzzle1301 {

    public static void main(String[] args) {
        Solution s = new Puzzle1301().new Solution();
        System.out.println(Arrays.toString(s.pathsWithMaxScore(Arrays.asList(
                "E11345",
                "X452XX",
                "3X43X4",
                "44X312",
                "23452X",
                "1342XS"
        ))));
    }

    class Solution {
        public int[] pathsWithMaxScore(List<String> board) {
            int n = board.size(), mod = (int) 1e9 + 7;

            int[][][] dp = new int[n][n][2];
            dp[n - 1][n - 1] = new int[]{0, 1};

            char[][] grid = new char[n][];
            for (int i = 0; i < n; i++) {
                grid[i] = board.get(i).toCharArray();
            }

            for (int i = n - 2; i >= 0; i--) {
                if (grid[n - 1][i] != 'X' && dp[n - 1][i + 1][1] > 0) {
                    dp[n - 1][i][0] += dp[n - 1][i + 1][0] + (grid[n - 1][i] - '0');
                    dp[n - 1][i][1] = dp[n - 1][i + 1][1];
                }

                if (grid[i][n - 1] != 'X' && dp[i + 1][n - 1][1] > 0) {
                    dp[i][n - 1][0] += dp[i + 1][n - 1][0] + (grid[i][n - 1] - '0');
                    dp[i][n - 1][1] = dp[i + 1][n - 1][1];
                }
            }

            for (int i = n - 2; i >= 0; i--) {
                for (int j = n - 2; j >= 0; j--) {
                    if (grid[i][j] == 'X') continue;

                    dp[i][j][0] = dp[i + 1][j][0];
                    dp[i][j][1] = dp[i + 1][j][1];

                    if (dp[i][j + 1][0] > dp[i][j][0]) {
                        dp[i][j][0] = dp[i][j + 1][0];
                        dp[i][j][1] = dp[i][j + 1][1];
                    } else if (dp[i][j + 1][0] == dp[i][j][0]) {
                        dp[i][j][1] += dp[i][j + 1][1];
                    }

                    if (dp[i + 1][j + 1][0] >= dp[i][j][0]) {
                        dp[i][j][0] = dp[i + 1][j + 1][0];
                        dp[i][j][1] = dp[i + 1][j + 1][1];
                    }
                    if (dp[i][j][1] > 0) {
                        dp[i][j][0] += grid[i][j] - '0';
                        dp[i][j][1] %= mod;
                    }
                }
            }
            if (dp[0][0][0] > 0)
                dp[0][0][0] -= ('E' - '0');
            return dp[0][0];
        }
    }
}
