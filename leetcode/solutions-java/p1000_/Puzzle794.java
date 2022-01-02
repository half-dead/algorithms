package p1000_;

/**
 * https://leetcode.com/problems/valid-tic-tac-toe-state/
 *
 * @author half-dead
 */
public class Puzzle794 {

    class Solution {
        public boolean validTicTacToe(String[] board) {
            boolean xWin = false, oWin = false;
            int xCnt = 0, oCnt = 0;
            for (String row : board) {
                if (row.equals("XXX")) xWin = true;
                else if (row.equals("OOO")) oWin = true;
                for (char c : row.toCharArray()) {
                    if (c == 'X') xCnt++;
                    else if (c == 'O') oCnt++;
                }
            }
            for (int i = 0; i < 3; i++) {
                char c = board[0].charAt(i);
                if (c != ' ' && c == board[1].charAt(i) && c == board[2].charAt(i)) {
                    if (c == 'X') xWin = true;
                    else oWin = true;
                }
            }
            char c = board[1].charAt(1);
            if (c != ' ' && c == board[0].charAt(0) && c == board[2].charAt(2)) {
                if (c == 'X') xWin = true;
                else oWin = true;
            }
            if (c != ' ' && c == board[0].charAt(2) && c == board[2].charAt(0)) {
                if (c == 'X') xWin = true;
                else oWin = true;
            }
            if (xCnt < oCnt || xCnt > oCnt + 1) return false;
            if (xWin && oWin) return false;
            return (xWin && xCnt == oCnt + 1) || (oWin && xCnt == oCnt) || (!xWin && !oWin);
        }
    }
}
