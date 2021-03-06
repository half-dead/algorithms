/*
https://leetcode.com/problems/largest-triangle-area/description/

You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.

Example:
    Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
    Output: 2
    Explanation: The five points are show in the figure below. The red triangle is the largest.

Notes:
    3 <= points.length <= 50.
    No points will be duplicated.
     -50 <= points[i][j] <= 50.
    Answers within 10^-6 of the true value will be accepted as correct.
 */

package p1000_;

/**
 * @author half-dead
 */
public class Puzzle812_LargestTriangleArea {
    class Solution {
        public double largestTriangleArea(int[][] points) {
            double max = 0F;
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    for (int k = j + 1; k < points.length; k++) {
                        max = Math.max(max, area(points[i], points[j], points[k]));
                    }
                }
            }
            return max;
        }

        public double area(int[] p1, int[] p2, int[] p3) {
            return 0.5 * Math.abs(p1[0] * (p2[1] - p3[1]) + p2[0] * (p3[1] - p1[1]) + p3[0] * (p1[1] - p2[1]));
        }
    }
}
