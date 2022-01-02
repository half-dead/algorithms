package p2000_;

/**
 * @author half-dead
 */
public class Puzzle1733 {

    class Solution {
        public int minimumTeachings(int n, int[][] lgs, int[][] f) {
            int m = lgs.length;

            boolean[][] map = new boolean[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int lg : lgs[i - 1]) {
                    map[i][lg] = true;
                }
            }

            boolean[] skips = new boolean[f.length];
            for (int i = 0; i < f.length; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[f[i][0]][j] && map[f[i][1]][j]) {
                        skips[i] = true;
                        break;
                    }
                }
            }


            int res = m;
            for (int lg = 1; lg <= n; lg++) {
                boolean[] teached = new boolean[m + 1];
                for (int i = 0; i < f.length; i++) {
                    if (skips[i]) continue;

                    int[] r = f[i];
                    int a = r[0], b = r[1];
                    boolean ba = map[a][lg], bb = map[b][lg];
                    if (!ba) teached[a] = true;
                    if (!bb) teached[b] = true;
                }
                int cnt = 0;
                for (boolean x : teached) if (x) cnt++;
                res = Math.min(res, cnt);
            }
            return res;
        }
    }
}
