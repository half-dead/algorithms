package p0500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 *
 * @author half-dead
 */
public class Puzzle051_NQueens {
    public static void main(String[] args) {
        Puzzle051_NQueens p = new Puzzle051_NQueens();
        Solution s = p.new Solution();
        for (int i = 1; i <= 15; i++) {
            List<List<String>> res = s.solveNQueens(i);
            System.out.println(res.size());
        }
    }

    class Solution {
        public List<List<String>> solveNQueens(int n) {
            char[][] grid = new char[n][n];
            for (char[] row : grid) {
                Arrays.fill(row, '.');
            }
            List<List<String>> result = new ArrayList<>();
            dfs(result, n, grid, n, 0);
            return result;
        }

        void dfs(List<List<String>> result, int n, char[][] grid, int left, int row) {
            if (left == 0) {
                result.add(encode(grid, n));
            } else {
                for (int c = 0; c < n; c++) {
                    if (row == 0 || check(grid, row, c, n)) {
                        grid[row][c] = 'Q';
                        dfs(result, n, grid, left - 1, row + 1);
                        grid[row][c] = '.';
                    }
                }
            }
        }

        List<String> encode(char[][] grid, int n) {
            List<String> result = new ArrayList<>(n);
            for (char[] row : grid) {
                result.add(new String(row));
            }
            return result;
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
}
