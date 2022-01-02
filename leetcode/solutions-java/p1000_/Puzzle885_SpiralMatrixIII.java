package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/spiral-matrix-iii/
 *
 * @author half-dead
 */
public class Puzzle885_SpiralMatrixIII {
    public static void main(String[] args) {
        Solution solution = new Puzzle885_SpiralMatrixIII().new Solution();
        int[][] matrix = solution.spiralMatrixIII(5, 6, 1, 4);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    class Solution {
        public int[][] spiralMatrixIII(int rows, int cols, int r0, int c0) {
            int n = 0, max = rows * cols, r = r0, c = c0;
            int[][] result = new int[max][2];
            int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int steps = 1, step = 0, loopCnt = 0, directionIdx = 0;
            while (n < max) {
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    result[n][0] = r;
                    result[n++][1] = c;
                }
                r += directions[directionIdx][0];
                c += directions[directionIdx][1];

                if (++step == steps) {
                    step = 0;
                    directionIdx = (directionIdx + 1) % directions.length;
                    if (++loopCnt == 2) {
                        ++steps;
                        loopCnt = 0;
                    }
                }
            }
            return result;
        }
    }
}
