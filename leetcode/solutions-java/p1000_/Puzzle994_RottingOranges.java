package p1000_;

/**
 * https://leetcode.com/problems/rotting-oranges/
 *
 * @author half-dead
 */
public class Puzzle994_RottingOranges {
    public static void main(String[] args) {
        Puzzle994_RottingOranges p = new Puzzle994_RottingOranges();
        Solution s = p.new Solution();
        System.out.println(s.orangesRotting(new int[][]{{1, 2}}));
    }

    class Solution {
        public int orangesRotting(int[][] grid) {
            int rows = grid.length, cols = grid[0].length;
            int minute = 0;
            while (true) {
                int freshCount = 0, infectedCount = 0;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        boolean infected = false;
                        if (grid[i][j] == 1) {
                            freshCount++;
                            infected |= i > 0 && grid[i - 1][j] == 2;
                            infected |= j > 0 && grid[i][j - 1] == 2;
                            infected |= i + 1 < rows && grid[i + 1][j] == 2;
                            infected |= j + 1 < cols && grid[i][j + 1] == 2;
                        }
                        if (infected) {
                            grid[i][j] = -1;
                            infectedCount++;
                        }
                    }
                }
                if (infectedCount == 0 && freshCount > 0) return -1;
                if (freshCount == 0) break;

                minute++;
                for (int i = 0; i < rows; i++)
                    for (int j = 0; j < cols; j++)
                        if (grid[i][j] == -1) grid[i][j] = 2;
            }
            return minute;
        }
    }
}
