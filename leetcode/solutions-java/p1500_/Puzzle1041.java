package p1500_;

/**
 * https://leetcode.com/problems/robot-bounded-in-circle/
 *
 * @author half-dead
 */
public class Puzzle1041 {

    class Solution {
        public boolean isRobotBounded(String instructions) {
            char[] cs = instructions.toCharArray();
            int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
            int r = 0, c = 0, d = 0;
            for (char ch : cs) {
                if (ch == 'G') {
                    r += dirs[d][0];
                    c += dirs[d][1];
                } else if (ch == 'L') {
                    d = (d + 1) % 4;
                } else {
                    d = (d + 3) % 4;
                }
            }
            return d != 0 || (r == 0 && c == 0);
        }
    }
}
