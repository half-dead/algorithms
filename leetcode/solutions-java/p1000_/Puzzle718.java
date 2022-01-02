package p1000_;

/**
 * @author half-dead
 */
public class Puzzle718 {

    // O(M*N) time, O(N) space
    class Solution {
        public int findLength(int[] A, int[] B) {
            int m = A.length, n = B.length, max = 0;
            int[] dp = new int[n + 1];
            for (int i = m - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (A[i] == B[j]) {
                        dp[j] = 1 + dp[j + 1];
                        max = Math.max(max, dp[j]);
                    } else {
                        dp[j] = 0;
                    }
                }
            }
            return max;
        }
    }

    // O(M*N) time, O(M*N) space
    class Solution1 {
        public int findLength(int[] A, int[] B) {
            int m = A.length, n = B.length, max = 0;
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (A[i] == B[j]) {
                        max = Math.max(max, dp[i + 1][j + 1] = dp[i][j] + 1);
                    }
                }
            }
            return max;
        }
    }
}
