package p1000_;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/swim-in-rising-water/
 *
 * @author half-dead
 */
public class Puzzle778 {

    public static void main(String[] args) {
        Solution s = new Puzzle778().new Solution();
        System.out.println(s.swimInWater(new int[][]{{0, 2}, {1, 3}}));
        System.out.println(s.swimInWater(new int[][]{{3, 2}, {0, 1}}));
        System.out.println(s.swimInWater(new int[][]{{10, 12, 4, 6}, {9, 11, 3, 5}, {1, 7, 13, 8}, {2, 0, 15, 14}}));
        System.out.println(s.swimInWater(new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}));
    }

    class Solution {
        int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        public int swimInWater(int[][] grid) {
            int n = grid.length, res = Math.max(grid[0][0], grid[n - 1][n - 1]);
            boolean[][] flag = new boolean[n][n];
            flag[0][0] = true;

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
            pq.offer(new int[]{0, 0, grid[0][0]});

            while (true) {
                int[] top = pq.poll() ;
                int r = top[0], c = top[1], max = top[2];
                res = Math.max(res, max);
                if (r == n - 1 && c == n - 1) {
                    break;
                }

                for (int[] dir : dirs) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr < 0 || nc < 0 || nr >= n || nc >= n || flag[nr][nc]) {
                        continue;
                    }
                    flag[nr][nc] = true;
                    pq.offer(new int[]{nr, nc, grid[nr][nc]});
                }
            }
            return res;
        }
    }

    class BinarySearchSolution {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int n = 0;

        public int swimInWater(int[][] grid) {
            n = grid.length;

            int low = grid[n - 1][n - 1];
            int high = n * n - 1;
            while (low < high) {
                int mid = low + ((high - low) >> 1);
                boolean[][] visited = new boolean[n][n];
                if (!back(0, 0, visited, mid, grid)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }

        private boolean back(int x, int y, boolean[][] visited, int rain, int[][] grid) {
            boolean valid = x >= 0 && x < n && y >= 0 && y < n && !visited[x][y];
            if (!valid || rain < grid[x][y]) {
                return false;
            }
            if (x == n - 1 && y == n - 1) {
                return true;
            }
            visited[x][y] = true;
            for (int[] dir : dirs) {
                if (back(x + dir[0], y + dir[1], visited, rain, grid)) {
                    return true;
                }
            }
            return false;
        }
    }
}
