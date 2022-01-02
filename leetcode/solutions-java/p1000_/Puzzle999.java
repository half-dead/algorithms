package p1000_;

/**
 * https://leetcode.com/problems/available-captures-for-rook/
 *
 * @author half-dead
 */
public class Puzzle999 {

    class Solution {
        public int numRookCaptures(char[][] board) {
            int r = 0, c = 0, res = 0;
            for (int i = 0; i < 8; i++)
                for (int j = 0; j < 8; j++)
                    if (board[i][j] == 'R') {
                        r = i;
                        c = j;
                        i += 8;
                        j += 8;
                    }
            int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int d = 0; d < 4; d++) {
                int x = dirs[d][0], y = dirs[d][1];
                for (int p = r + x, q = c + y; p >= 0 && q >= 0 && p < 8 && q < 8; p += x, q += y) {
                    if (board[p][q] == 'p') {
                        res++;
                        break;
                    } else if (board[p][q] == 'B') {
                        break;
                    }
                }
            }
            return res;
        }
    }
}
