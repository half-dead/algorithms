package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
 *
 * @author half-dead
 */
public class Puzzle1637 {

    class Solution {
        public int maxWidthOfVerticalArea(int[][] points) {
            Arrays.sort(points, (x, y) -> {
                return x[0] - y[0];
            });
            int res = 0;
            for (int i = points.length - 1; i > 0; i--) {
                res = Math.max(res, points[i][0] - points[i - 1][0]);
            }
            return res;
        }
    }
}
