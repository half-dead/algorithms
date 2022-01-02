package p1500_;

/**
 * https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
 *
 * @author half-dead
 */
public class Puzzle1275 {
    class Solution {
        public String tictactoe(int[][] moves) {
            int[][] m = new int[3][3];
            for (int i = 0; i < moves.length; i++) m[moves[i][0]][moves[i][1]] = (i & 1) + 1;

            int[] r = new int[]{
                    m[0][0] & m[0][1] & m[0][2],
                    m[1][0] & m[1][1] & m[1][2],
                    m[2][0] & m[2][1] & m[2][2],
                    m[0][0] & m[1][0] & m[2][0],
                    m[0][1] & m[1][1] & m[2][1],
                    m[0][2] & m[1][2] & m[2][2],
                    m[0][0] & m[1][1] & m[2][2],
                    m[0][2] & m[1][1] & m[2][0]
            };
            for (int v : r)
                if (v == 1) return "A";
                else if (v == 2) return "B";
            return moves.length == 9 ? "Draw" : "Pending";
        }
    }
}
