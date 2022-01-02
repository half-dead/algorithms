package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/cyclically-rotating-a-grid/
 *
 * @author half-dead
 */
public class Puzzle1914 {

    public static void main(String[] args) {
        Solution s = new Puzzle1914().new Solution();
        System.out.println(Arrays.deepToString(s.rotateGrid(new int[][]{
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}
        }, 2)));
    }

    class Solution {
        public int[][] rotateGrid(int[][] grid, int k) {
            int rows = grid.length, cols = grid[0].length;
            int times = Math.min(rows, cols) >> 1, t = 0;

            int[][] res = new int[rows][cols];
            int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            while (t < times) {
                int cnt = rows * 2 + cols * 2 - 4, shift = k % cnt;

                // calculate where should we start at source grid
                int srcRow = 0, srcCol = 0, srcDir = 0;
                if (shift < cols - 1) {
                    srcCol = shift;
                } else if (shift < rows + cols - 2) {
                    srcDir = 1;
                    srcCol = cols - 1;
                    srcRow = shift - srcCol;
                } else if (shift < rows + 2 * cols - 3) {
                    srcDir = 2;
                    srcRow = rows - 1;
                    srcCol = cnt - shift - srcRow;
                } else {
                    srcDir = 3;
                    srcRow = cnt - shift;
                }

                int destRow = 0, destCol = 0, destDir = 0;
                while (cnt-- > 0) {
                    // copy element from grid to res
                    res[t + destRow][t + destCol] = grid[t + srcRow][t + srcCol];

                    // move to next (clockwise)
                    destRow += dirs[destDir][0];
                    destCol += dirs[destDir][1];
                    srcRow += dirs[srcDir][0];
                    srcCol += dirs[srcDir][1];

                    // change direction if we meet a corner
                    if (destRow == 0 && (destCol == 0 || destCol == cols - 1)) destDir = (destDir + 1) % 4;
                    if (destRow == rows - 1 && (destCol == 0 || destCol == cols - 1)) destDir = (destDir + 1) % 4;
                    if (srcRow == 0 && (srcCol == 0 || srcCol == cols - 1)) srcDir = (srcDir + 1) % 4;
                    if (srcRow == rows - 1 && (srcCol == 0 || srcCol == cols - 1)) srcDir = (srcDir + 1) % 4;
                }

                rows -= 2;
                cols -= 2;
                t++;
            }
            return res;
        }
    }
}
