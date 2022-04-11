package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
 *
 * @author half-dead
 */
public class Puzzle1335 {

    public static void main(String[] args) {
        Solution solution = new Puzzle1335().new Solution();
        int xx = solution.minDifficulty(new int[]{
                795, 919, 126, 706, 454, 943, 893, 679, 130, 504, 98, 333, 742, 493, 929, 784, 993, 620, 25, 885, 441, 901, 797, 478, 570, 834, 420, 705, 958, 49, 517, 653, 686, 655, 261, 544, 15, 619, 999, 344, 524, 875, 856, 383, 567, 537, 515, 547, 916, 447, 992, 973, 411, 906, 220, 749, 936, 374, 223, 563, 185, 719, 160, 259, 70, 152, 770, 3, 285, 342, 289, 239, 390, 119, 459, 813, 900, 657, 211, 785, 14, 232, 2, 405, 204, 530, 50, 272, 884, 246, 966, 723, 388
        }, 3);
        System.out.println(xx);
    }

    // dp, O(n^2 * d) time, O(n * d) space
    // can be optimized to O(n) space
    class Solution {
        public int minDifficulty(int[] jobs, int d) {
            int n = jobs.length;
            if (n < d) return -1;

            int[][] dp = new int[d][n];
            for (int i = 0, max = 0; i < n; i++) {
                max = Math.max(max, jobs[i]);
                dp[0][i] = max;
            }

            for (int i = 1; i < d; i++) {
                Arrays.fill(dp[i], 200000);
                for (int j = i; j < n; j++) {
                    int max = jobs[j];
                    for (int k = j; k >= i; k--) {
                        max = Math.max(max, jobs[k]);
                        dp[i][j] = Math.min(dp[i][j], max + dp[i - 1][k - 1]);
                    }
                }
            }
            return dp[d - 1][n - 1];
        }
    }
}
