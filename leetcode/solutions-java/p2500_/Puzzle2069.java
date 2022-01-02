package p2500_;

/**
 * https://leetcode.com/problems/walking-robot-simulation-ii/
 *
 * @author half-dead
 */
public class Puzzle2069 {

    class Robot {

        int d = 1, p, x, y;
        int w, h;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        String[] ds = new String[]{"North", "East", "South", "West"};

        public Robot(int width, int height) {
            p = 2 * width + 2 * height - 4;
            w = width;
            h = height;
        }

        public void move(int num) {
            int steps = num % (2 * p);
            while (steps > 0) {
                int dx = dirs[d][0], dy = dirs[d][1];
                int nx = x + dx, ny = y + dy;
                if (nx >= 0 && nx < w && ny >= 0 && ny < h) {
                    x = nx;
                    y = ny;
                    steps--;
                } else {
                    d = (d + 3) % 4;
                }
            }
        }

        public int[] getPos() {
            return new int[]{x, y};
        }

        public String getDir() {
            return ds[d];
        }
    }
}
