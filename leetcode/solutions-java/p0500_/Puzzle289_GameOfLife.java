/*
https://leetcode.com/problems/game-of-life/description/

According to the Wikipedia's article: "The Game of Life, also known simply as Life,
is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules
(taken from the above Wikipedia article):
    Any live cell with fewer than two live neighbors dies, as if caused by under-population.
    Any live cell with two or three live neighbors lives on to the next generation.
    Any live cell with more than three live neighbors dies, as if by over-population..
    Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Write a function to compute the next state (after one update) of the board given its current state.
The next state is created by applying the above rules simultaneously to every cell in the current state,
where births and deaths occur simultaneously.

Example:

Input:
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output:
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
Follow up:
    Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
    In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */

package p0500_;

/**
 * @author half-dead
 */
public class Puzzle289_GameOfLife {

    class Solution {
        public void gameOfLife(int[][] board) {
            int rows = board.length;
            int cols = board[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int an = getAliveNeighbors(board, i, j, rows, cols);
                    if (an == 2 && board[i][j] == 1) {
                        board[i][j] |= 2;
                    }
                    if (an == 3) {
                        board[i][j] |= 2;
                    }
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] >= 2) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }

        int getAliveNeighbors(int[][] board, int r, int c, int rows, int cols) {
            int count = 0;
            int rs = r - 1, re = r + 1, cs = c - 1, ce = c + 1;
            if (rs < 0) {
                rs = 0;
            }
            if (cs < 0) {
                cs = 0;
            }
            if (re >= rows) {
                re = rows - 1;
            }
            if (ce >= cols) {
                ce = cols - 1;
            }
            for (int i = rs; i <= re; i++) {
                for (int j = cs; j <= ce; j++) {
                    if ((board[i][j] & 1) == 1) {
                        count++;
                    }
                }
            }
            return count - (board[r][c] & 1);
        }
    }
}
