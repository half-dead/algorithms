package p1000_;

/**
 * https://leetcode.com/problems/out-of-boundary-paths/
 *
 * @author half-dead
 */
public class Puzzle576 {
    public static void main(String[] args) {
        Solution s = new Puzzle576().new Solution();
        System.out.println(s.findPaths(5, 5, 7, 2, 2));
    }

    // top-down dp
    class Solution2 {
        public int findPaths(int m, int n, int N, int i, int j) {
            if (N == 0) return 0;
            int[][] dp = new int[m][n];
            int res = 0, mod = 1000000007;
            for (int r = 0, last = n - 1; r < m; r++) {
                dp[r][0]++;
                dp[r][last]++;
            }
            for (int c = 0, last = m - 1; c < n; c++) {
                dp[0][c]++;
                dp[last][c]++;
            }

            while (--N > 0) {
                res = (res + dp[i][j]) % mod;
                int[][] tmp = new int[m][n];
                for (int r = 0; r < m; r++) {
                    for (int c = 0; c < n; c++) {
                        if (r > 0) tmp[r][c] = dp[r - 1][c] % mod;
                        if (c > 0) tmp[r][c] = (tmp[r][c] + dp[r][c - 1]) % mod;
                        if (r + 1 < m) tmp[r][c] = (tmp[r][c] + dp[r + 1][c]) % mod;
                        if (c + 1 < n) tmp[r][c] = (tmp[r][c] + dp[r][c + 1]) % mod;
                    }
                }
                dp = tmp;
            }
            return (res + dp[i][j]) % mod;
        }
    }

    // bottom-up dp
    public class Solution {
        public int findPaths(int m, int n, int N, int i, int j) {
            if (N <= 0) return 0;

            int MOD = 1000000007, result = 0;
            int[][] dp = new int[m][n], dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            dp[i][j] = 1;

            while (N-- > 0) {
                int[][] temp = new int[m][n];
                for (int r = 0; r < m; r++) {
                    for (int c = 0; c < n; c++) {
                        for (int[] d : dirs) {
                            int nr = r + d[0], nc = c + d[1];
                            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                                result = (result + dp[r][c]) % MOD;
                            } else {
                                temp[nr][nc] = (temp[nr][nc] + dp[r][c]) % MOD;
                            }
                        }
                    }
                }
                dp = temp;
            }
            return result;
        }
    }
}
