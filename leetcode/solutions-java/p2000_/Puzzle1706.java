package p2000_;

/**
 * https://leetcode.com/problems/where-will-the-ball-fall/
 *
 * @author half-dead
 */
public class Puzzle1706 {

    class Solution {
        public int[] findBall(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                int r = 0, c = i;
                while (r < m) {
                    if (c + 1 < n && grid[r][c] == 1 && grid[r][c + 1] == 1) {
                        r++;
                        c++;
                    } else if (c > 0 && grid[r][c] == -1 && grid[r][c - 1] == -1) {
                        r++;
                        c--;
                    } else break;
                }
                res[i] = r == m ? c : -1;
            }
            return res;
        }
    }
}
