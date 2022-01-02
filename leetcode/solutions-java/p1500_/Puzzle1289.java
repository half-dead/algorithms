package p1500_;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum-ii/
 *
 * @author half-dead
 */
public class Puzzle1289 {
    public static void main(String[] args) {
        Solution s = new Puzzle1289().new Solution();
        System.out.println(s.minFallingPathSum(new int[][]{
                {-73, 61, 43, -48, -36},
                {3, 30, 27, 57, 10},
                {96, -76, 84, 59, -15},
                {5, -49, 76, 31, -7},
                {97, 91, 61, -46, 67}
        }));

    }

    class Solution {
        public int minFallingPathSum(int[][] arr) {
            int n = arr.length;
            int[][] dp = new int[n][n];
            System.arraycopy(arr[0], 0, dp[0], 0, n);

            for (int r = 1; r < n; r++) {
                int min1 = Integer.MAX_VALUE, minCol = -1, min2 = Integer.MAX_VALUE;
                for (int c = 0; c < n; c++) {
                    if (dp[r - 1][c] < min1) {
                        min2 = min1;
                        min1 = dp[r - 1][c];
                        minCol = c;
                    } else if (dp[r - 1][c] < min2) min2 = dp[r - 1][c];
                }

                for (int c = 0; c < n; c++) dp[r][c] = arr[r][c] + (c == minCol ? min2 : min1);
            }
            int res = Integer.MAX_VALUE;
            for (int c : dp[n - 1]) res = Math.min(res, c);
            return res;
        }
    }
}
