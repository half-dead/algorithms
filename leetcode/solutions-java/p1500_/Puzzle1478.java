package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/allocate-mailboxes/
 *
 * @author half-dead
 */
public class Puzzle1478 {

    // bottom-up dp, O(N^3) time, O(N^2) space
    class Solution {
        public int minDistance(int[] houses, int boxes) {
            int n = houses.length;
            Arrays.sort(houses);

            int[] psum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                psum[i] = psum[i - 1] + houses[i - 1];
            }

            int[][] dp = new int[boxes][n];
            for (int i = 0; i < n; i++) {
                dp[0][i] = cal(houses, psum, 0, i);
            }

            for (int k = 1; k < boxes; k++) {
                for (int i = k; i < n; i++) {
                    int min = 1000000;
                    for (int cut = 1; cut <= i; cut++) {
                        min = Math.min(min, dp[k - 1][cut - 1] + cal(houses, psum, cut, i));
                    }
                    dp[k][i] = min;
                }
            }
            return dp[boxes - 1][n - 1];
        }

        int cal(int[] houses, int[] psum, int i, int j) {
            int mid = (i + j) / 2;
            int left = houses[mid] * (mid - i + 1) - (psum[mid + 1] - psum[i]);
            int right = psum[j + 1] - psum[mid + 1] - houses[mid] * (j - mid);
            return left + right;
        }
    }
}
