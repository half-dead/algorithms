package p2000_;

/**
 * https://leetcode.com/problems/check-if-move-is-legal/
 *
 * @author half-dead
 */
public class Puzzle1958 {

    class Solution {
        public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
            // the difference of coordinates between two adjcent cell in all 8 directions
            int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {1, 0}, {-1, 0}};
            for (int d = 0; d < 8; d++) {
                int x = dirs[d][0], y = dirs[d][1];
                for (int dis = 2; dis < 8; dis++) {
                    int er = rMove + dis * x, ec = cMove + dis * y;

                    // early break if we are already out of bounds
                    if (er < 0 || ec < 0 || er >= 8 || ec >= 8) break;
                    // if two endpoints are not same color, skip
                    if (board[er][ec] != color) continue;

                    boolean legal = true;
                    // check middle part
                    for (int r = rMove + x, c = cMove + y; r != er || c != ec; r += x, c += y) {
                        if (board[r][c] == '.' || board[r][c] == color) {
                            legal = false;
                            break;
                        }
                    }
                    if (legal) return true;
                }
            }
            return false;
        }
    }
}
