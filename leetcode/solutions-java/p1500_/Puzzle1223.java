package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/dice-roll-simulation/
 *
 * @author half-dead
 */
public class Puzzle1223 {

    public static void main(String[] args) {
        Solution s = new Puzzle1223().new Solution();
        System.out.println(s.dieSimulator(100, new int[]{7, 5, 15, 5, 1, 7}));
    }

    class MySolution {
        public int dieSimulator(int n, int[] rollMax) {
            long[][] dp = new long[n + 1][7];
            dp[1][0] = dp[1][1] = dp[1][2] = dp[1][3] = dp[1][4] = dp[1][5] = 1;
            dp[1][6] = 6;
            long mod = 1000000007;
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < 6; j++) {
                    if (rollMax[j] == 1) {
                        dp[i][j] = dp[i - 1][6] - dp[i - 1][j];
                    } else if (i <= rollMax[j]) {
                        dp[i][j] = dp[i - 1][6];
                    } else {
                        long v = 0;
                        for (int k = 1; k <= rollMax[j]; k++) {
                            v += dp[i - k][6] - dp[i - k][j];
                        }
                        dp[i][j] = v;
                    }
                    dp[i][6] += dp[i][j];
                }
                for (int j = 0; j < 7; j++) {
                    dp[i][j] %= mod;
                }
            }
            return (int) ((dp[n][6] + mod) % mod);
        }
    }

    class Solution {
        public int dieSimulator(int n, int[] rollMax) {
            long mod = 1000000007;
            long[][] dp = new long[n + 1][7];
            Arrays.fill(dp[1], 1);
            dp[0][6] = 1;
            dp[1][6] = 6;
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < 6; j++) {
                    int prev = i - rollMax[j] - 1;
                    if (prev < 0) {
                        dp[i][j] = dp[i - 1][6];
                    } else {
                        dp[i][j] = dp[i - 1][6] - dp[prev][6] + dp[prev][j];
                        if (dp[i][j] < 0) dp[i][j] += mod;
                    }
                }
                for (int j = 0; j < 6; j++) dp[i][6] += dp[i][j];
                dp[i][6] %= mod;
            }
            return (int) (dp[n][6] % mod);
        }
    }
}
