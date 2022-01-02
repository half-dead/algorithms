package p0500_;

/**
 * https://leetcode.com/problems/dungeon-game/
 *
 * @author half-dead
 */
public class Puzzle174_DungeonGame {
    public static void main(String[] args) {
        Puzzle174_DungeonGame p = new Puzzle174_DungeonGame();
        Solution s = p.new Solution();
        System.out.println(s.calculateMinimumHP(new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5},
        }));
    }

    class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            int rows = dungeon.length, cols = dungeon[0].length;
            int[][] dp = new int[rows][cols];
            for (int i = rows - 1; i >= 0; i--) {
                for (int j = cols - 1; j >= 0; j--) {
                    int hp = 0;
                    if (j == cols - 1 && i == rows - 1) hp = 1;
                    else if (j == cols - 1) hp = dp[i + 1][j];
                    else if (i == rows - 1) hp = dp[i][j + 1];
                    else hp = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = Math.max(1, hp - dungeon[i][j]);
                }
            }
            return dp[0][0];
        }
    }
}
