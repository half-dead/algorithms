package p0500_;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii/
 *
 * @author half-dead
 */
public class Puzzle375 {

    public static void main(String[] args) {
        Solution solution = new Puzzle375().new Solution();
        solution.getMoneyAmount(300);
    }

    // bottom-up DP, O(N^3) time, O(N^2) space
    class Solution {
        public int getMoneyAmount(int n) {
            // dp[i][j] is the minimum cost to guarantee a win of range [i,j](both inclusive)
            int[][] dp = new int[n + 1][n + 1];

            // dp[i][i] = 0, since there is only 1 number in that range

            for (int range = 1; range < n; range++) {

                for (int from = 1; from <= n - range; from++) {

                    int min = Integer.MAX_VALUE;
                    // for every number in range[from, from+dis], try to guess it
                    for (int i = 0; i <= range; i++) {
                        // suppose our guess is wrong
                        int guess = from + i;
                        // minimum cost of left part
                        int left = from <= guess - 1 ? dp[from][guess - 1] : 0;
                        // minimum cost of right part
                        int right = guess + 1 <= from + range ? dp[guess + 1][from + range] : 0;

                        min = Math.min(min, guess + Math.max(left, right));
                    }
                    dp[from][from + range] = min;
                }
            }
            return dp[1][n];
        }
    }
}
