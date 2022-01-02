package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-square/
 *
 * @author half-dead
 */
public class Puzzle593 {

    class Solution {
        public boolean validSquare(int[] a, int[] b, int[] c, int[] d) {
            int ab = dis(a, b), ac = dis(a, c), ad = dis(a, d), bc = dis(b, c), bd = dis(b, d), cd = dis(c, d);
            int[] m = new int[]{ab, ac, ad, bc, bd, cd};
            Arrays.sort(m);
            return m[0] == m[1] && m[1] == m[2] && m[2] == m[3] && m[3] < m[4] && m[4] == m[5] && m[0] * 2 == m[4];
        }

        int dis(int[] p, int[] q) {
            int dx = p[0] - q[0], dy = p[1] - q[1];
            return dx * dx + dy * dy;
        }
    }

}
