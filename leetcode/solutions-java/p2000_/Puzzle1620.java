package p2000_;

/**
 * https://leetcode.com/problems/coordinate-with-maximum-network-quality/
 *
 * @author half-dead
 */
public class Puzzle1620 {

    class Solution {
        public int[] bestCoordinate(int[][] towers, int radius) {
            int minx = 50, maxx = 0, miny = 50, maxy = 0;
            for (int[] tower : towers) {
                minx = Math.min(minx, tower[0]);
                miny = Math.min(miny, tower[1]);
                maxx = Math.max(maxx, tower[0]);
                maxy = Math.max(maxy, tower[1]);
            }
            int limit = 51, max = 0, r2 = radius * radius;
            int[][] m = new int[limit][limit];
            for (int[] tower : towers) {
                int x = tower[0], y = tower[1], q = tower[2];
                for (int r = minx; r <= maxx; r++) {
                    int rx2 = (r - x) * (r - x);
                    for (int c = miny; c <= maxy; c++) {
                        int ed = rx2 + (c - y) * (c - y);
                        if (ed <= r2) {
                            m[r][c] += (int) Math.floor(q / (1 + Math.sqrt(ed)));
                        }
                    }
                }
            }

            int[] res = new int[2];
            for (int r = 0; r < limit; r++) {
                for (int c = 0; c < limit; c++) {
                    if (m[r][c] > max) {
                        max = m[r][c];
                        res = new int[]{r, c};
                    }
                }
            }
            return res;
        }
    }

    // brute-force
    class Solution1 {
        public int[] bestCoordinate(int[][] towers, int radius) {
            int limit = 151, max = 0, r2 = radius * radius;
            int[][] m = new int[limit][limit];
            for (int[] tower : towers) {
                int x = tower[0], y = tower[1], q = tower[2];
                for (int r = x - radius; r <= x + radius; r++) {
                    int rx2 = (r - x) * (r - x);
                    for (int c = y - radius; c <= y + radius; c++) {
                        int ed = rx2 + (c - y) * (c - y);
                        if (ed <= r2) {
                            m[r + 50][c + 50] += (int) Math.floor(q / (1 + Math.sqrt(ed)));
                        }
                    }
                }
            }

            int[] res = new int[2];
            for (int r = 0; r < limit; r++) {
                for (int c = 0; c < limit; c++) {
                    if (m[r][c] > max) {
                        max = m[r][c];
                        res = new int[]{r - 50, c - 50};
                    }
                }
            }
            return res;
        }
    }
}
