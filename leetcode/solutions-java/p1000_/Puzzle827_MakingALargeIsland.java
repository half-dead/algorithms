package p1000_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/making-a-large-island/
 *
 * @author half-dead
 */
public class Puzzle827_MakingALargeIsland {
    public static void main(String[] args) {
        Puzzle827_MakingALargeIsland p = new Puzzle827_MakingALargeIsland();
        Solution s = p.new Solution();
        System.out.println(s.largestIsland(new int[][]{{1, 0}, {0, 1}}));
        System.out.println(s.largestIsland(new int[][]{{1, 1}, {0, 1}}));
        System.out.println(s.largestIsland(new int[][]{{1, 1}, {1, 1}}));
    }

    class Solution {
        public int largestIsland(int[][] grid) {
            int n = grid.length, result = 0, color = 2;

            // the maximum island count of a n*n grid is (n*n)/2 + 1
            int[] sizes = new int[n * n / 2 + 1 + 2];

            // loop through every island
            // paint it with a unique color and count island size
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (grid[i][j] == 1) {
                        int[] size = new int[1];
                        dfs(grid, n, i, j, color, size);
                        sizes[color++] = size[0];
                        // in case there is no zero cell in the grid
                        result = Math.max(result, size[0]);
                    }

            // for every neighbour of a zero cell, check whether it's a part of an island
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (grid[i][j] == 0) {
                        int area = 1;

                        Set<Integer> seen = new HashSet<>(4);
                        if (i > 0 && grid[i - 1][j] != 0) seen.add(grid[i - 1][j]);
                        if (j > 0 && grid[i][j - 1] != 0) seen.add(grid[i][j - 1]);
                        if (i + 1 < n && grid[i + 1][j] != 0) seen.add(grid[i + 1][j]);
                        if (j + 1 < n && grid[i][j + 1] != 0) seen.add(grid[i][j + 1]);

                        for (int islandColor : seen) area += sizes[islandColor];
                        result = Math.max(result, area);
                    }

            return result;
        }

        private void dfs(int[][] grid, int n, int r, int c, int color, int[] size) {
            if (r < 0 || c < 0 || r == n || c == n || grid[r][c] != 1) return;
            grid[r][c] = color;
            size[0]++;
            dfs(grid, n, r - 1, c, color, size);
            dfs(grid, n, r, c - 1, color, size);
            dfs(grid, n, r + 1, c, color, size);
            dfs(grid, n, r, c + 1, color, size);
        }
    }

}
