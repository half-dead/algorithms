package p1000_;

/**
 * https://leetcode.com/problems/minimum-cost-to-merge-stones/
 *
 * @author half-dead
 */
public class Puzzle1000 {

    public static void main(String[] args) {
        Solution s = new Puzzle1000().new Solution();
        System.out.println(s.mergeStones(new int[]{3, 2, 4, 1}, 2));
    }

    class Solution {
        public int mergeStones(int[] stones, int k) {
            int n = stones.length;
            if ((n - 1) % (k - 1) != 0) return -1;

            int[] ps = new int[n + 1];
            for (int i = 0; i < n; i++) ps[i + 1] = ps[i] + stones[i];

            int[][] dp = new int[n][n];
            for (int range = k; range <= n; range += (k - 1)) {
                int prange = range - (k - 1);

                for (int i = range - 1; i < n; i++) {

                    int min = Integer.MAX_VALUE;
                    for (int j = prange - 1; j <= i; j++) {
                        min = Math.min(min, dp[j - prange + 1][j]);
                    }
                    dp[i - range + 1][i] = ps[i + 1] - ps[i + 1 - range] + min;
                }
            }
            return dp[0][n - 1];
        }
    }
}
