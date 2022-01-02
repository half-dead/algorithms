package p2000_;

/**
 * https://leetcode.com/problems/stone-game-vii/
 *
 * @author half-dead
 */
public class Puzzle1690 {

    public static void main(String[] args) {
        Solution s = new Puzzle1690().new Solution();
        System.out.println(s.stoneGameVII(new int[]{7, 90, 5, 1, 100, 10, 10, 2}));
    }


    // top-down dp
    class Solution {
        public int stoneGameVII(int[] stones) {
            int n = stones.length;
            int[] ps = new int[n + 1];
            for (int i = 0; i < n; i++) ps[i + 1] = ps[i] + stones[i];

            int[][] dp = new int[n][n];
            return dfs(ps, dp, 0, n - 1);
        }

        int dfs(int[] ps, int[][] dp, int i, int j) {
            if (i == j) return 0;
            if (dp[i][j] != 0) return dp[i][j];

            int left = dfs(ps, dp, i + 1, j), right = dfs(ps, dp, i, j - 1);
            int takeLeft = ps[j + 1] - ps[i + 1], takeRight = ps[j] - ps[i];
            return dp[i][j] = Math.max(takeLeft - left, takeRight - right);
        }
    }
}
