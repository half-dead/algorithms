package p0500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 *
 * @author half-dead
 */
public class Puzzle452 {

    class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points.length == 0) return 0;
            Arrays.sort(points, (p, q) -> p[1] - q[1]);

            int res = 1, arrow = points[0][1];
            for (int[] b : points) {
                if (b[0] > arrow) {
                    res++;
                    arrow = b[1];
                }
            }
            return res;
        }
    }
}
