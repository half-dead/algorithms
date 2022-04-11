package p2500_;

/**
 * https://leetcode.com/problems/count-artifacts-that-can-be-extracted/
 *
 * @author half-dead
 */
public class Puzzle2201 {
    class Solution {
        public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
            boolean[][] b = new boolean[n][n];
            for (int[] d : dig) {
                b[d[0]][d[1]] = true;
            }

            int res = 0;
            for (int[] a : artifacts) {
                int r0 = a[0], r1 = a[2];
                int c0 = a[1], c1 = a[3];
                boolean flag = true;
                for (int i = r0; i <= r1; i++) {
                    for (int j = c0; j <= c1; j++) {
                        if (!b[i][j]) {
                            flag = false;
                        }
                    }
                }
                if (flag) res++;
            }
            return res;
        }
    }
}
