package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/paint-house-iii/
 *
 * @author half-dead
 */
public class Puzzle1473 {

    // bottom-up dp, O(m * target * n * n) time
    class Solution {
        public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
            int max = Integer.MAX_VALUE, res = max;

            int[][][] dp = new int[m + 1][target + 1][n + 1];
            for (int[][] a : dp) for (int[] b : a) Arrays.fill(b, max);
            Arrays.fill(dp[0][0], 0);
            Arrays.fill(dp[0][1], 0);

            for (int h = 1; h <= m; h++) {
                for (int g = 1; g <= Math.min(h, target); g++) {
                    int color = houses[h - 1];
                    if (color != 0) {
                        dp[h][g][color] = findMin(dp[h - 1][g][color], color, n, dp[h - 1][g - 1]);
                    } else {
                        for (int c = 1; c <= n; c++) {
                            int min = findMin(dp[h - 1][g][c], c, n, dp[h - 1][g - 1]);
                            if (min < max) dp[h][g][c] = min + cost[h - 1][c - 1];
                        }
                    }
                }
            }

            for (int x : dp[m][target]) res = Math.min(res, x);
            return res == max ? -1 : res;
        }

        int findMin(int min, int color, int n, int[] arr) {
            int res = min;
            for (int c = 1; c <= n; c++) {
                if (c != color) res = Math.min(res, arr[c]);
            }
            return res;
        }
    }
}
