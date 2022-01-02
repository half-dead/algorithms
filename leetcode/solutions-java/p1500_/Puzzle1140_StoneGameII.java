package p1500_;

/**
 * https://leetcode.com/problems/stone-game-ii/
 *
 * @author half-dead
 */
public class Puzzle1140_StoneGameII {
    public static void main(String[] args) {
        Solution s = new Puzzle1140_StoneGameII().new Solution();
        // 10
        System.out.println(s.stoneGameII(new int[]{2, 7, 9, 4, 4}));
        // 56
        System.out.println(s.stoneGameII(new int[]{8, 9, 5, 4, 5, 4, 1, 1, 9, 3, 1, 10, 5, 9, 6, 2, 7, 6, 6, 9}));
        // 98008
        System.out.println(s.stoneGameII(new int[]{8270, 7145, 575, 5156, 5126, 2905, 8793, 7817, 5532, 5726, 7071, 7730, 5200, 5369, 5763, 7148, 8287, 9449, 7567, 4850, 1385, 2135, 1737, 9511, 8065, 7063, 8023, 7729, 7084, 8407}));

    }

    class Solution {
        public int stoneGameII(int[] piles) {
            int len = piles.length;
            int[][] sums = new int[len][len], dp = new int[len + 1][len];
            for (int i = 0; i < len; i++)
                for (int j = i; j < len; j++)
                    sums[i][j] = (i == j) ? piles[j] : sums[i][j - 1] + piles[j];
            return recur(sums, dp, 0, 1, len);
        }

        public int recur(int[][] sums, int[][] dp, int i, int m, int len) {
            if (i >= len) return 0;
            if (dp[m][i] > 0) return dp[m][i];

            int max = 0;
            for (int x = Math.min(m * 2, len); x >= 1; x--)
                max = Math.max(max, (i + x >= len) ? sums[i][len - 1] : sums[i][i + x - 1] + (sums[i + x][len - 1] - recur(sums, dp, i + x, Math.max(m, x), len)));
            return (dp[m][i] = max);
        }
    }

}
