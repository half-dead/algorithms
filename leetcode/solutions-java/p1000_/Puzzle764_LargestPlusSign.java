package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-plus-sign/
 *
 * @author half-dead
 */
public class Puzzle764_LargestPlusSign {
    public static void main(String[] args) {
        Puzzle764_LargestPlusSign p = new Puzzle764_LargestPlusSign();
        Solution s = p.new Solution();
        System.out.println(s.orderOfLargestPlusSign(5, new int[][]{{4, 2}}));
    }

    // https://leetcode.com/problems/largest-plus-sign/discuss/113314/JavaC++Python-O(N2)-solution-using-only-one-grid-matrix/114381
    class Solution {
        public int orderOfLargestPlusSign(int n, int[][] mines) {
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(grid[i], n);
            }
            for (int[] m : mines) {
                grid[m[0]][m[1]] = 0;
            }
            for (int i = 0; i < n; i++) {
                int left = 0, right = 0, up = 0, down = 0;
                for (int j = 0, k = n - 1; j < n; j++, k--) {
                    left = grid[i][j] == 0 ? 0 : left + 1;
                    right = grid[i][k] == 0 ? 0 : right + 1;
                    up = grid[j][i] == 0 ? 0 : up + 1;
                    down = grid[k][i] == 0 ? 0 : down + 1;

                    grid[i][j] = Math.min(grid[i][j], left);
                    grid[i][k] = Math.min(grid[i][k], right);
                    grid[j][i] = Math.min(grid[j][i], up);
                    grid[k][i] = Math.min(grid[k][i], down);
                    pt(grid);
                }
            }

            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res = Math.max(res, grid[i][j]);
                }
            }
            return res;
        }

        void pt(int[][] grid) {
            for (int[] row : grid) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("-------------------------");
        }
    }

    class MySolution {
        int ans;

        public int orderOfLargestPlusSign(int n, int[][] mines) {
            ans = 0;
            boolean[][] grid = new boolean[n][n];
            for (boolean[] row : grid) {
                Arrays.fill(row, true);
            }
            for (int[] mine : mines) {
                grid[mine[0]][mine[1]] = false;
            }

            int max = (n - 1) / 2 + 1;
            int top = (n - 1) / 2, bottom = n / 2, left = top, right = bottom;
            while (max > 0) {
                if (checkRow(grid, top, left, right, max)) {
                    break;
                }
                if (checkRow(grid, bottom, left, right, max)) {
                    break;
                }
                if (checkCol(grid, left, top, bottom, max)) {
                    break;
                }
                if (checkCol(grid, right, top, bottom, max)) {
                    break;
                }
                max--;
                top--;
                left--;
                bottom++;
                right++;
            }
            return ans;
        }

        private boolean checkRow(boolean[][] grid, int row, int left, int right, int max) {
            for (int i = left; i <= right; i++) {
                int size = count(grid, row, i);
                if (size > 0) {
                    ans = Math.max(ans, size);
                }
                if (size == max) {
                    return true;
                }
            }
            return false;
        }

        private boolean checkCol(boolean[][] grid, int col, int top, int bottom, int max) {
            for (int i = top + 1; i <= bottom - 1; i++) {
                int size = count(grid, i, col);
                if (size > 0) {
                    ans = Math.max(ans, size);
                }
                if (size == max) {
                    return true;
                }
            }
            return false;
        }

        private int count(boolean[][] grid, int i, int j) {
            if (grid[i][j]) {
                int len = grid.length;
                int count = 1;
                boolean up, bottom, left, right;
                do {
                    up = i - count >= 0 && grid[i - count][j];
                    bottom = i + count < len && grid[i + count][j];
                    left = j - count >= 0 && grid[i][j - count];
                    right = j + count < len && grid[i][j + count];
                    count++;
                } while (up && bottom && left && right);
                return count - 1;
            }
            return 0;
        }
    }
}
