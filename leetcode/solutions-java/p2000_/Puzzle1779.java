package p2000_;

/**
 * https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
 *
 * @author half-dead
 */
public class Puzzle1779 {

    class Solution {
        public int nearestValidPoint(int x, int y, int[][] points) {
            int res = Integer.MAX_VALUE, j = -1;
            for (int i = 0; i < points.length; i++) {
                int[] p = points[i];
                if (p[0] == x || p[1] == y) {
                    int dis = Math.abs(p[0] - x) + Math.abs(p[1] - y);
                    if (dis < res) {
                        res = dis;
                        j = i;
                    }
                }
            }
            return j;
        }
    }
}
