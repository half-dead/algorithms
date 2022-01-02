package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/stone-game/
 * https://leetcode.com/problems/stone-game/discuss/154610/C%2B%2BJavaPython-DP-or-Just-return-true
 *
 * @author half-dead
 */
public class Puzzle877_StoneGame {
    public static void main(String[] args) {
        Puzzle877_StoneGame p = new Puzzle877_StoneGame();
        Solution s = p.new Solution();
        s.stoneGame(new int[]{1, 2, 4, 6, 5, 3});
    }

    class Solution {
        public boolean stoneGame(int[] p) {
            int n = p.length;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = p[i];
            }
            for (int d = 1; d < n; d++) {
                for (int i = 0; i < n - d; i++) {
                    dp[i][i + d] = Math.max(p[i] - dp[i + 1][i + d], p[i + d] - dp[i][i + d - 1]);
                }
            }
            return dp[0][n - 1] > 0;
        }
    }

    // O(n) time & space complexity
    class Solution2 {
        public boolean stoneGame(int[] p) {
            int[] dp = Arrays.copyOf(p, p.length);
            for (int d = 1; d < p.length; d++)
                for (int i = 0; i < p.length - d; i++)
                    dp[i] = Math.max(p[i] - dp[i + 1], p[i + d] - dp[i]);
            return dp[0] > 0;
        }
    }

    // O(1) complexity
    class Solution3 {
        public boolean stoneGame(int[] piles) {
            return true;
        }
    }

}
