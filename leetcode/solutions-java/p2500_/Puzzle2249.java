package p2500_;

/**
 * https://leetcode.com/problems/count-lattice-points-inside-a-circle/
 *
 * @author half-dead
 */
public class Puzzle2249 {

    class Solution {
        public int countLatticePoints(int[][] circles) {
            int ans = 0, xMin = 500, xMax = -1, yMin = 500, yMax = -1;
            for (int[] c : circles) {
                xMin = Math.min(xMin, c[0] - c[2]);
                xMax = Math.max(xMax, c[0] + c[2]);
                yMin = Math.min(yMin, c[1] - c[2]);
                yMax = Math.max(yMax, c[1] + c[2]);
            }

            for (int x = xMin; x <= xMax; x++) {
                for (int y = yMin; y <= yMax; y++) {
                    for (int[] c : circles) {
                        if (distance(c, x, y) <= c[2] * c[2]) {
                            ans++;
                            break;
                        }
                    }
                }
            }
            return ans;
        }

        int distance(int[] circle, int x, int y) {
            return (circle[0] - x) * (circle[0] - x) + (circle[1] - y) * (circle[1] - y);
        }
    }
}
