package p1500_;

/**
 * Check If It Is a Straight Line
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/
 *
 * @author half-dead
 */
public class Puzzle1232 {
    class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            int[] p1 = coordinates[0], p2 = coordinates[1];
            int dx = p1[0] - p2[0], dy = p1[1] - p2[1];
            for (int i = 2; i < coordinates.length; i++)
                if (dx * (p1[1] - coordinates[i][1]) != dy * (p1[0] - coordinates[i][0])) return false;
            return true;
        }
    }
}
