package p0500_;

// Write a program to solve a Sudoku puzzle by filling the empty cells.
//
// Empty cells are indicated by the character '.'.
//
// You may assume that there will be only one unique solution.

/**
 * https://oj.leetcode.com/problems/sudoku-solver/
 */
public class Puzzle037_SudokuSolver {

    public static void main(String[] args) throws InterruptedException {
        char[][] input = new char[][]{
                ".8.5.....".toCharArray(),
                "....3.2..".toCharArray(),
                "..9.2.7..".toCharArray(),
                "..7.....6".toCharArray(),
                ".4.....5.".toCharArray(),
                "1..2....7".toCharArray(),
                "..8.6...3".toCharArray(),
                "...3.16.4".toCharArray(),
                "..1..9...".toCharArray(),
        };

        Puzzle037_SudokuSolver p = new Puzzle037_SudokuSolver();
        Solution s = p.new Solution();
        s.solveSudoku(input);
        for (char[] row : input) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public class Solution {
        public void solveSudoku(char[][] board) {
            boolean[][] rows = new boolean[9][9], cols = new boolean[9][9], boxes = new boolean[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char c = board[i][j];
                    if (c != '.') {
                        mark(rows, cols, boxes, i, j, c, true);
                    }
                }
            }
            dfs(board, rows, cols, boxes, 0);
        }

        boolean dfs(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] boxes, int index) {
            if (index >= 81) {
                return true;
            }

            boolean solved = false;
            int row = index / 9, col = index % 9;
            if (board[row][col] == '.') {
                for (int n = 0; n < 9; n++) {
                    if (!rows[row][n] && !cols[col][n] && !boxes[3 * (row / 3) + (col / 3)][n]) {
                        char c = (char) (n + '1');
                        board[row][col] = c;
                        mark(rows, cols, boxes, row, col, c, true);

                        solved = dfs(board, rows, cols, boxes, index + 1);

                        if (!solved) {
                            board[row][col] = '.';
                            mark(rows, cols, boxes, row, col, c, false);
                        }
                    }
                }
            } else {
                solved = dfs(board, rows, cols, boxes, index + 1);
            }
            return solved;
        }

        void mark(boolean[][] rows, boolean[][] cols, boolean[][] boxes, int i, int j, char c, boolean b) {
            rows[i][c - '1'] = b;
            cols[j][c - '1'] = b;
            boxes[3 * (i / 3) + (j / 3)][c - '1'] = b;
        }
    }
}
