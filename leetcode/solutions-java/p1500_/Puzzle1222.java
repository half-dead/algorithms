package p1500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/queens-that-can-attack-the-king/
 *
 * @author half-dead
 */
public class Puzzle1222 {

    class Solution {
        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
            int[][] directions = new int[][]{
                    {-1, 1}, {-1, 0}, {-1, -1}, {0, 1}, {0, -1}, {1, 1}, {1, 0}, {1, -1}
            };
            boolean[][] q = new boolean[8][8];
            for (int[] queen : queens) {
                q[queen[0]][queen[1]] = true;
            }

            List<List<Integer>> res = new ArrayList<>();
            int r = king[0], c = king[1];
            for (int[] dir : directions) {
                int x = dir[0], y = dir[1], nr = r + x, nc = c + y;
                while (nr >= 0 && nr < 8 && nc >= 0 && nc < 8) {
                    if (q[nr][nc]) {
                        res.add(Arrays.asList(nr, nc));
                        break;
                    }
                    nr += x;
                    nc += y;
                }
            }
            return res;
        }
    }
}
