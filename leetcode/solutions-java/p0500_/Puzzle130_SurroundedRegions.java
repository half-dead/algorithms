/*
https://leetcode.com/problems/surrounded-regions/

Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:
    X X X X
    X O O X
    X X O X
    X O X X
After running your function, the board should be:
    X X X X
    X X X X
    X X X X
    X O X X
Explanation:
    Surrounded regions shouldn’t be on the border, which means that
    any 'O' on the border of the board are not flipped to 'X'.
    Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
    Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */

package p0500_;

/**
 * @author half-dead
 */
public class Puzzle130_SurroundedRegions {

    class Solution {
        public void solve(char[][] board) {
            int rows = board.length;
            if (rows == 0) {
                return;
            }
            int cols = board[0].length;
            for (int i = 0; i < cols; i++) {
                tryInfect(board, 0, i, rows, cols);
                tryInfect(board, rows - 1, i, rows, cols);
            }
            for (int i = 0; i < rows; i++) {
                tryInfect(board, i, 0, rows, cols);
                tryInfect(board, i, cols - 1, rows, cols);
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    } else if (board[i][j] == 'Z') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        public void tryInfect(char[][] board, int x, int y, int rows, int cols) {
            if (board[x][y] == 'O') {
                board[x][y] = 'Z';

                if (x > 0) {
                    tryInfect(board, x - 1, y, rows, cols);
                }
                if (x < rows - 1) {
                    tryInfect(board, x + 1, y, rows, cols);
                }
                if (y > 0) {
                    tryInfect(board, x, y - 1, rows, cols);
                }
                if (y < cols - 1) {
                    tryInfect(board, x, y + 1, rows, cols);
                }
            }

        }
    }
}
