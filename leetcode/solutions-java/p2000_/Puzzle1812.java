package p2000_;

/**
 * https://leetcode.com/problems/determine-color-of-a-chessboard-square/
 *
 * @author half-dead
 */
public class Puzzle1812 {

    class Solution {
        public boolean squareIsWhite(String c) {
            return (c.charAt(1) - '1') % 2 != (c.charAt(0) - 'a') % 2;
        }
    }
}
