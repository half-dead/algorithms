package p0500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/n-queens-ii/
 *
 * @author half-dead
 */
public class Puzzle052_NQueensII {

    class Solution {
        int count;

        public int totalNQueens(int n) {
            char[][] grid = new char[n][n];
            for (char[] row : grid) {
                Arrays.fill(row, '.');
            }
            dfs(n, grid, n, 0);
            return count;
        }

        void dfs(int n, char[][] grid, int left, int row) {
            if (left == 0) {
                count++;
            } else {
                for (int c = 0; c < n; c++) {
                    if (row == 0 || check(grid, row, c, n)) {
                        grid[row][c] = 'Q';
                        dfs(n, grid, left - 1, row + 1);
                        grid[row][c] = '.';
                    }
                }
            }
        }

        boolean check(char[][] grid, int r, int c, int n) {
            for (int i = 0; i < n; i++) if (grid[r][i] == 'Q') return false;
            for (int i = 0; i < n; i++) if (grid[i][c] == 'Q') return false;
            for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) if (grid[i][j] == 'Q') return false;
            for (int i = r + 1, j = c + 1; i < n && j < n; i++, j++) if (grid[i][j] == 'Q') return false;
            for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) if (grid[i][j] == 'Q') return false;
            for (int i = r + 1, j = c - 1; i < n && j >= 0; i++, j--) if (grid[i][j] == 'Q') return false;
            return true;
        }
    }

    public class Solution2 {
        int count = 0;

        public int totalNQueens(int n) {
            boolean[] cols = new boolean[n];     // columns   |
            boolean[] d1 = new boolean[2 * n];   // diagonals \
            boolean[] d2 = new boolean[2 * n];   // diagonals /
            backtracking(0, cols, d1, d2, n);
            return count;
        }

        void backtracking(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
            if (row == n) count++;

            for (int col = 0; col < n; col++) {
                int id1 = col - row + n;
                int id2 = col + row;

                if (cols[col] || d1[id1] || d2[id2]) continue;

                cols[col] = true;
                d1[id1] = true;
                d2[id2] = true;
                backtracking(row + 1, cols, d1, d2, n);
                cols[col] = false;
                d1[id1] = false;
                d2[id2] = false;
            }
        }
    }

    public class Solution3 {
        public int totalNQueens(int n) {
            boolean[] col = new boolean[n];
            boolean[] tlbr = new boolean[2 * n + 1]; // top left -> bottom right
            boolean[] trbl = new boolean[2 * n + 1]; // top right -> bottom left
            return tryPut(0, n, col, tlbr, trbl);
        }

        private int tryPut(int row, int size, boolean[] col, boolean[] tlbr, boolean[] trbl) {
            int result = 0;
            for (int i = 0; i < size; i++)
                if (!col[i] && !tlbr[size - 1 - row + i] && !trbl[row + i]) {
                    if (row == size - 1) {
                        result++;
                    } else {
                        col[i] = true;
                        tlbr[size - 1 - row + i] = true;
                        trbl[row + i] = true;
                        result += tryPut(row + 1, size, col, tlbr, trbl);
                        col[i] = false;
                        tlbr[size - 1 - row + i] = false;
                        trbl[row + i] = false;
                    }
                }
            return result;
        }
    }
}
