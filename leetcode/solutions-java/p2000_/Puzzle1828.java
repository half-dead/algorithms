package p2000_;

/**
 * https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/
 *
 * @author half-dead
 */
public class Puzzle1828 {

    class Solution {
        public int[] countPoints(int[][] points, int[][] queries) {
            int[] res = new int[queries.length];
            int i = 0;
            for (int[] q : queries) {
                int cnt = 0;
                for (int[] p : points) {
                    int dx = p[0] - q[0], dy = p[1] - q[1];
                    if (dx * dx + dy * dy <= q[2] * q[2])
                        cnt++;
                }
                res[i++] = cnt;
            }
            return res;
        }
    }
}
