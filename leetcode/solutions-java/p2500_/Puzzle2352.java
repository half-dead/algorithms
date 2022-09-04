package p2500_;

/**
 * https://leetcode.com/problems/equal-row-and-column-pairs/
 *
 * @author half-dead
 */
public class Puzzle2352 {
    class Solution {
        public int equalPairs(int[][] grid) {
            int n = grid.length, res = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int i = 0;
                    while (i < n && grid[r][i] == grid[i][c]) {
                        i++;
                    }
                    if (i == n) res++;
                }
            }
            return res;
        }
    }
}
