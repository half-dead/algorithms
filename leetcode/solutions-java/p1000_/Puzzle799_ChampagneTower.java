package p1000_;

/**
 * https://leetcode.com/problems/champagne-tower/
 *
 * @author half-dead
 */
public class Puzzle799_ChampagneTower {
    public static void main(String[] args) {
        Puzzle799_ChampagneTower p = new Puzzle799_ChampagneTower();
        Solution s = p.new Solution();
        System.out.println(s.champagneTower(50, 13, 1));
    }

    class Solution {
        public double champagneTower(int poured, int row, int col) {
            double[] dp = new double[row + 1];
            dp[0] = poured;
            for (int i = 1; i <= row; i++) {
                int j = i;
                dp[j] = dp[j - 1] > 1 ? (dp[j - 1] - 1) / 2 : 0;
                while (--j > 0)
                    dp[j] = (dp[j] > 1 ? (dp[j] - 1) / 2 : 0) + (dp[j - 1] > 1 ? (dp[j - 1] - 1) / 2 : 0);
                dp[0] = dp[0] > 1 ? (dp[0] - 1) / 2 : 0;
            }
            return Math.min(1, dp[col]);
        }
    }
}