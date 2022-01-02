package p0500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 *
 * @author half-dead
 */
public class Puzzle417 {

    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
            if (matrix.length == 0) return new ArrayList<>();

            int rows = matrix.length, cols = matrix[0].length;
            boolean[][] pcf = new boolean[rows][cols], atl = new boolean[rows][cols];

            for (int c = 0; c < cols; c++) dfs(matrix, pcf, 0, c, rows, cols);
            for (int r = 1; r < rows; r++) dfs(matrix, pcf, r, 0, rows, cols);
            for (int c = 0; c < cols; c++) dfs(matrix, atl, rows - 1, c, rows, cols);
            for (int r = 0; r < rows - 1; r++) dfs(matrix, atl, r, cols - 1, rows, cols);

            List<List<Integer>> result = new ArrayList<>();
            for (int r = 0; r < rows; r++)
                for (int c = 0; c < cols; c++)
                    if (pcf[r][c] && atl[r][c]) result.add(Arrays.asList(r, c));
            return result;
        }

        void dfs(int[][] m, boolean[][] state, int r, int c, int rows, int cols) {
            state[r][c] = true;
            if (r > 0 && m[r][c] <= m[r - 1][c] && !state[r - 1][c]) dfs(m, state, r - 1, c, rows, cols);
            if (c > 0 && m[r][c] <= m[r][c - 1] && !state[r][c - 1]) dfs(m, state, r, c - 1, rows, cols);
            if (r + 1 < rows && m[r][c] <= m[r + 1][c] && !state[r + 1][c]) dfs(m, state, r + 1, c, rows, cols);
            if (c + 1 < cols && m[r][c] <= m[r][c + 1] && !state[r][c + 1]) dfs(m, state, r, c + 1, rows, cols);
        }
    }
}
