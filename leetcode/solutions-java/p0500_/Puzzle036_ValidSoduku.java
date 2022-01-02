package p0500_;

// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
//
// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


/**
 * https://leetcode.com/problems/valid-sudoku/
 */
public class Puzzle036_ValidSoduku {

    public static void main(String[] args) {
        Puzzle036_ValidSoduku p = new Puzzle036_ValidSoduku();
        Solution2 s = p.new Solution2();
        char[][] board = new char[][]{
                "......5..".toCharArray(),
                ".........".toCharArray(),
                "........3".toCharArray(),
                ".2.7.....".toCharArray(),
                "8365....1".toCharArray(),
                ".....1...".toCharArray(),
                "2.......5".toCharArray(),
                "........7".toCharArray(),
                "...4...7.".toCharArray()
        };
        boolean valid = s.isValidSudoku(board);
        System.out.println(valid);
    }

    public class Solution {
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                int row = 0;
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        int mask = 1 << (board[i][j] - '0');
                        if ((row & mask) != 0) {
                            return false;
                        } else {
                            row |= mask;
                        }
                    }
                }

                int column = 0;
                for (int j = 0; j < 9; j++) {
                    if (board[j][i] != '.') {
                        int mask = 1 << (board[j][i] - '0');
                        if ((column & mask) != 0) {
                            return false;
                        } else {
                            column |= mask;
                        }
                    }
                }
            }

            int cr = 0, cc = 0;
            for (int i = 1; i <= 9; i++) {
                int cell = 0;
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (board[cr + j][cc + k] != '.') {
                            int mask = 1 << (board[cr + j][cc + k] - '0');
                            if ((cell & mask) != 0) {
                                return false;
                            } else {
                                cell |= mask;
                            }
                        }
                    }
                }
                cr = ((3 * i) / 9) * 3;
                cc = (3 * i) % 9;
            }
            return true;
        }
    }

    public class Solution2 {
        public boolean isValidSudoku(char[][] board) {
            boolean[][] rows = new boolean[9][9];
            boolean[][] cols = new boolean[9][9];
            boolean[][] cels = new boolean[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        int num = (board[i][j] - '0') - 1;
                        int k = i / 3 * 3 + j / 3;
                        if (rows[i][num] || cols[j][num] || cels[k][num]) {
                            return false;
                        } else {
                            rows[i][num] = cols[j][num] = cels[k][num] = true;
                        }
                    }
                }
            }
            return true;
        }
    }

}
