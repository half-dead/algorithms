package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-total-space-wasted-with-k-resizing-operations/
 *
 * @author half-dead
 */
public class Puzzle1959 {

    class Solution {
        final int INF = Integer.MAX_VALUE;

        public int minSpaceWastedKResizing(int[] nums, int k) {
            int n = nums.length;
            int[][] dp = new int[k + 1][n];
            for (int i = 0; i <= k; i++) Arrays.fill(dp[i], INF);
            return dfs(nums, k, 0, n, dp);
        }

        int dfs(int[] nums, int k, int i, int n, int[][] dp) {
            if (i == n) return 0;
            if (k == -1) return INF;
            if (dp[k][i] < INF) return dp[k][i];

            int max = 0, sum = 0, min = INF;
            for (int j = i; j < n; j++) {
                max = Math.max(max, nums[j]);
                sum += nums[j];
                int wasted = (j - i + 1) * max - sum;
                int prev = dfs(nums, k - 1, j + 1, n, dp);
                min = Math.min(min, prev < INF ? prev + wasted : INF);
            }
            return dp[k][i] = min;
        }
    }


    // bottom-up DP, O(K*N^2)time, O(K*N)space
    class BottomUpDPSolution {
        public int minSpaceWastedKResizing(int[] nums, int k) {
            int n = nums.length;

            // prefix-sum
            int[] sums = new int[n];
            sums[0] = nums[0];
            for (int i = 1; i < n; i++) sums[i] = sums[i - 1] + nums[i];

            // range max
            int[][] max = new int[n][n];
            for (int i = 0; i < n; i++) {
                int temp = nums[i];
                for (int j = i; j < n; j++) {
                    temp = Math.max(temp, nums[j]);
                    max[i][j] = temp;
                }
            }

            int[][] dp = new int[k + 1][n];
            for (int i = 0; i < n; i++) {
                dp[0][i] = (i + 1) * max[0][i] - sums[i];
            }
            for (int x = 1; x <= k; x++) {
                for (int i = 0; i < n; i++) {
                    int min = Integer.MAX_VALUE;
                    for (int j = 0; j <= i; j++) {
                        int left = dp[x - 1][j];
                        int right = j == i ? 0 : ((i - j) * max[j + 1][i] - (sums[i] - sums[j]));
                        min = Math.min(min, left + right);
                    }
                    dp[x][i] = min;
                }
            }
            return dp[k][n - 1];
        }
    }
}
