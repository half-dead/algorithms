package p2500_;

/**
 * https://leetcode.com/problems/check-if-word-can-be-placed-in-crossword/
 *
 * @author half-dead
 */
public class Puzzle2018 {

    class Solution {
        public boolean placeWordInCrossword(char[][] board, String word) {
            int m = board.length, n = board[0].length;
            String reverse = new StringBuilder(word).reverse().toString();
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (board[r][c] == '#') continue;

                    if (c == 0 || board[r][c - 1] == '#') {
                        if (check(board, r, c, word, true)) return true;
                        if (check(board, r, c, reverse, true)) return true;
                    }
                    if (r == 0 || board[r - 1][c] == '#') {
                        if (check(board, r, c, word, false)) return true;
                        if (check(board, r, c, reverse, false)) return true;
                    }
                }
            }
            return false;
        }

        private boolean check(char[][] board, int r, int c, String word, boolean horizontal) {
            int m = board.length, n = board[0].length;
            for (int i = 0, len = word.length(); i < len; i++) {
                if (r == m || n == c) return false;
                if (board[r][c] == '#') return false;
                if (board[r][c] != ' ' && board[r][c] != word.charAt(i)) return false;

                if (horizontal) c++;
                else r++;
            }
            if (horizontal && (c == n || board[r][c] == '#')) return true;
            if (!horizontal && (r == m || board[r][c] == '#')) return true;
            return false;
        }
    }
}
