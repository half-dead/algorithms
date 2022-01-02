package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
 *
 * @author half-dead
 */
public class Puzzle689 {
    public static void main(String[] args) {
        Solution s = new Puzzle689().new Solution();
        System.out.println(Arrays.toString(s.maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2)));
    }

    class Solution {
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            int m = 3, n = nums.length;

            int[] ps = new int[n + 1], res = new int[m];
            for (int i = 0; i < n; i++) ps[i + 1] = ps[i] + nums[i];

            int[][] dp = new int[m + 1][n + 1], idx = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = i * k, maxJ = n + 1 - (m - i) * k; j < maxJ; j++) {
                    int currMax = ps[j] - ps[j - k] + dp[i - 1][j - k];
                    if (currMax > dp[i][j - 1]) {
                        dp[i][j] = currMax;
                        idx[i][j] = j - k;
                    } else {
                        dp[i][j] = dp[i][j - 1];
                        idx[i][j] = idx[i][j - 1];
                    }
                }
            }

            for (int i = m - 1, j = n; i >= 0; i--) {
                res[i] = idx[i + 1][j];
                j = res[i];
            }
            return res;
        }
    }
}
