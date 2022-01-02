package p1500_;

/**
 * https://leetcode.com/problems/pizza-with-3n-slices/
 *
 * @author half-dead
 */
public class Puzzle1388 {

    public static void main(String[] args) {
        Solution s = new Puzzle1388().new Solution();
        System.out.println(s.maxSizeSlices(new int[]{9, 5, 1, 7, 8, 4, 4, 5, 5, 8, 7, 7}));
    }

    // two pass dp, O(N*N/3) time O(N*N/3) space
    // can be improved to O(N) space
    class Solution {
        public int maxSizeSlices(int[] slices) {
            int n = slices.length, m = n / 3;
            int[][] dp = new int[m][n];

            // first round, set slices[0] to 0, find a max
            int temp = slices[0];
            slices[0] = 0;
            System.arraycopy(slices, 0, dp[0], 0, n);
            for (int i = 1; i < m; i++) {
                int max = 0;
                for (int j = 2 * i; j < n; j++) {
                    max = Math.max(max, dp[i - 1][j - 2]);
                    dp[i][j] = Math.max(dp[i][j], max + slices[j]);
                }
            }

            // second round, recover slices[0], set slices[n-1] to 0, find a max
            slices[0] = temp;
            slices[n - 1] = 0;
            System.arraycopy(slices, 0, dp[0], 0, n);
            for (int i = 1; i < m; i++) {
                int max = 0;
                for (int j = 2 * i; j < n; j++) {
                    max = Math.max(max, dp[i - 1][j - 2]);
                    dp[i][j] = Math.max(dp[i][j], max + slices[j]);
                }
            }

            int res = 0;
            for (int x : dp[m - 1]) res = Math.max(res, x);
            return res;
        }
    }
}
