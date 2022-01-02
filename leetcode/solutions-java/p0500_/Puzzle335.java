package p0500_;

/**
 * https://leetcode.com/problems/self-crossing/
 *
 * @author half-dead
 */
public class Puzzle335 {

    class Solution {
        public boolean isSelfCrossing(int[] distance) {
            int[][] dirs = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
            int[][] buffer = new int[6][4];
            int[] root = new int[]{0, 0, 0, 0};
            for (int i = 0, d = 0, n = distance.length; i < n; i++) {
                int[] prev = i == 0 ? root : buffer[(i - 1) % 6];
                int x = prev[2], y = prev[3];
                int nx = x + dirs[d][0] * distance[i], ny = y + dirs[d][1] * distance[i];

                int[] curr = new int[]{x, y, nx, ny};
                buffer[i % 6] = curr;
                d = (d + 1) % 4;

                for (int j = 3; j <= 5; j++) {
                    if (i - j < 0) break;
                    if (cross(curr, buffer[(i - j) % 6])) return true;
                }
            }
            return false;
        }

        private boolean cross(int[] a, int[] b) {
            return !(Math.min(a[0], a[2]) > Math.max(b[0], b[2]) ||
                    Math.max(a[0], a[2]) < Math.min(b[0], b[2]) ||
                    Math.min(a[1], a[3]) > Math.max(b[1], b[3]) ||
                    Math.max(a[1], a[3]) < Math.min(b[1], b[3]));
        }
    }
}
