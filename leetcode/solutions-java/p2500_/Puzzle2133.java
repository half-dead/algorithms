package p2500_;

/**
 * https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
 *
 * @author half-dead
 */
public class Puzzle2133 {

    class Solution {
        public boolean checkValid(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                int cnt = 0;
                boolean[] mark = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (!mark[matrix[i][j]]) {
                        mark[matrix[i][j]] = true;
                        cnt++;
                    }
                }
                if (cnt < n) return false;
            }

            for (int i = 0; i < n; i++) {
                int cnt = 0;
                boolean[] mark = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (!mark[matrix[j][i]]) {
                        mark[matrix[j][i]] = true;
                        cnt++;
                    }
                }
                if (cnt < n) return false;
            }

            return true;
        }
    }
}
