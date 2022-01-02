package p1000_;

import util.Print;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minesweeper/
 *
 * @author half-dead
 */
public class Puzzle529 {
    public static void main(String[] args) {
        Solution s = new Puzzle529().new Solution();
        char[][] board = s.updateBoard(new char[][]{
                "EEEEE".toCharArray(),
                "EEMEE".toCharArray(),
                "EEEEE".toCharArray(),
                "EEEEE".toCharArray(),
        }, new int[]{3, 0});
        Print.pt(board);
    }

    class Solution {
        final int[][] neighbours = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        public char[][] updateBoard(char[][] board, int[] click) {
            dfs(board, board.length, board[0].length, click[0], click[1]);
            return board;
        }

        void dfs(char[][] board, int rows, int cols, int r, int c) {
            if (board[r][c] == 'M') {
                board[r][c] = 'X';
            } else if (board[r][c] == 'E') {
                int mines = 0;
                for (int[] neighbour : neighbours) {
                    int nr = r + neighbour[0], nc = c + neighbour[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && board[nr][nc] == 'M') mines++;
                }
                if (mines > 0) {
                    board[r][c] = (char) ('0' + mines);
                    return;
                }
                board[r][c] = 'B';
                for (int[] neighbour : neighbours) {
                    int nr = r + neighbour[0], nc = c + neighbour[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && board[nr][nc] == 'E') {
                        dfs(board, rows, cols, nr, nc);
                    }
                }
            }
        }
    }

    class BFSSolution {
        public char[][] updateBoard(char[][] board, int[] click) {
            int rows = board.length, cols = board[0].length;
            boolean[][] visited = new boolean[rows][cols];
            int[][] neighbours = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
            Queue<Coordinate> q = new LinkedList<>();
            q.offer(new Coordinate(click[0], click[1]));
            while (q.size() > 0) {
                for (int i = 0, size = q.size(); i < size; i++) {
                    Coordinate coordinate = q.poll();
                    int r = coordinate.r, c = coordinate.c;
                    char state = board[r][c];

                    if (state == 'M') {
                        board[r][c] = 'X';
                        return board;
                    } else if (state == 'E') {
                        int mines = 0;
                        for (int[] neighbour : neighbours) {
                            int nr = r + neighbour[0], nc = c + neighbour[1];
                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && board[nr][nc] == 'M') mines++;
                        }

                        if (mines > 0) {
                            board[r][c] = (char) ('0' + mines);
                            continue;
                        }

                        board[r][c] = 'B';
                        for (int[] neighbour : neighbours) {
                            int nr = r + neighbour[0], nc = c + neighbour[1];
                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && board[nr][nc] == 'E' && !visited[nr][nc]) {
                                visited[nr][nc] = q.offer(new Coordinate(nr, nc));
                            }
                        }
                    }
                }
            }
            return board;
        }

        class Coordinate {
            int r, c;

            Coordinate(int r, int c) {
                this.r = r;
                this.c = c;
            }
        }
    }
}
