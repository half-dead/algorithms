package p2000_;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-groups-of-farmland/
 *
 * @author half-dead
 */
public class Puzzle1992 {

    class Solution {
        public int[][] findFarmland(int[][] land) {
            int m = land.length, n = land[0].length, k = 0;

            boolean[][] v = new boolean[m][n];
            List<int[]> q = new LinkedList<>();
            for (int top = 0; top < m; top++) {
                for (int left = 0; left < n; left++) {
                    if (land[top][left] == 1 && !v[top][left]) {
                        int bottom = top, right = left;
                        // find bottom-right
                        while (bottom < m && land[bottom][left] == 1) bottom++;
                        while (right < n && land[top][right] == 1) right++;

                        // add to queue
                        q.add(new int[]{top, left, bottom - 1, right - 1});

                        // mark as visited
                        for (int i = top; i < bottom; i++) {
                            for (int j = left; j < right; j++) {
                                v[i][j] = true;
                            }
                        }
                    }
                }
            }
            int[][] res = new int[q.size()][4];
            for (int[] f : q) res[k++] = f;
            return res;
        }
    }
}
