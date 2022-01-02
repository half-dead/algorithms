package p0500_;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/trapping-rain-water-ii/
 *
 * @author half-dead
 */
public class Puzzle407 {
    public static void main(String[] args) {
        Solution s = new Puzzle407().new Solution();
        System.out.println(s.trapRainWater(new int[][]{
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1},
        }));
    }

    // PriorityQueue solution, 20ms
        // under given condition(0 <= h <= 20000, 0 <= r,c <= 110), we could use integer instead of Object
    class Solution {
        public int trapRainWater(int[][] matrix) {
            int rows = matrix.length, cols = matrix[0].length, trap = 0;
            PriorityQueue<Integer> borders = new PriorityQueue<>();
            boolean[][] state = new boolean[rows][cols];
            for (int r = 0; r < rows; r++) {
                pushBorder(matrix, borders, state, r, 0, 0);
                pushBorder(matrix, borders, state, r, cols - 1, 0);
            }
            for (int c = 0; c < cols; c++) {
                pushBorder(matrix, borders, state, 0, c, 0);
                pushBorder(matrix, borders, state, rows - 1, c, 0);
            }

            while (!borders.isEmpty()) {
                int bar = borders.poll();
                int h = bar >> 16, r = 127 & (bar >> 8), c = bar & 127;
                if (r > 0) trap += pushBorder(matrix, borders, state, r - 1, c, h);
                if (c > 0) trap += pushBorder(matrix, borders, state, r, c - 1, h);
                if (r + 1 < rows) trap += pushBorder(matrix, borders, state, r + 1, c, h);
                if (c + 1 < cols) trap += pushBorder(matrix, borders, state, r, c + 1, h);
            }
            return trap;
        }

        private int pushBorder(int[][] matrix, PriorityQueue<Integer> q, boolean[][] b, int r, int c, int h) {
            if (b[r][c]) return 0;

            b[r][c] = true;
            int trap = 0;
            if (h > matrix[r][c]) {
                trap = h - matrix[r][c];
                matrix[r][c] = h;
            }
            q.offer((matrix[r][c] << 16) | (r << 8) | c);
            return trap;
        }
    }

    // Non-PriorityQueue solution
    class Solution1 {
        public int trapRainWater(int[][] matrix) {
            int rows = matrix.length, cols = matrix[0].length;

            int[][] copy = new int[rows][cols];
            for (int i = 0; i < rows; i++) System.arraycopy(matrix[i], 0, copy[i], 0, cols);

            boolean update = true, init = true;
            while (update) {
                update = false;
                for (int i = 1; i < rows - 1; i++) {
                    for (int j = 1; j < cols - 1; j++) {
                        int val = Math.max(matrix[i][j], Math.min(copy[i - 1][j], copy[i][j - 1]));
                        if (init || val < copy[i][j]) {
                            copy[i][j] = val;
                            update = true;
                        }
                    }
                }
                init = false;
                for (int i = rows - 2; i >= 1; i--) {
                    for (int j = cols - 2; j >= 1; j--) {
                        int val = Math.max(matrix[i][j], Math.min(copy[i + 1][j], copy[i][j + 1]));
                        if (val < copy[i][j]) {
                            copy[i][j] = val;
                            update = true;
                        }
                    }
                }
            }
            int sum = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int trap = copy[i][j] - matrix[i][j];
                    if (trap > 0) sum += trap;
                }
            }
            return sum;
        }
    }

}
