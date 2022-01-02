package p1000_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/shortest-bridge/
 *
 * @author half-dead
 */
public class Puzzle934 {

    public static void main(String[] args) {
        Solution s = new Puzzle934().new Solution();
        System.out.println(s.shortestBridge(new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 1}}));
    }

    class Solution {
        public int shortestBridge(int[][] grid) {
            for (int r = 0, n = grid.length; r < n; r++)
                for (int c = 0; c < n; c++)
                    if (grid[r][c] == 1) {
                        dfs(grid, n, r, c);
                        return bfs(grid);
                    }
            throw new RuntimeException();
        }

        void dfs(int[][] grid, int n, int r, int c) {
            if (r < 0 || c < 0 || r == n || c == n || grid[r][c] != 1) return;
            grid[r][c] = 2;
            dfs(grid, n, r - 1, c);
            dfs(grid, n, r + 1, c);
            dfs(grid, n, r, c - 1);
            dfs(grid, n, r, c + 1);
        }

        int bfs(int[][] grid) {
            int color = 2, n = grid.length;
            while (true) {
                for (int r = 0; r < n; r++)
                    for (int c = 0; c < n; c++)
                        if (grid[r][c] == color) {
                            if (check(grid, n, r, c)) return color - 2;

                            if (r > 0 && grid[r - 1][c] == 0) grid[r - 1][c] = color + 1;
                            if (r < n - 1 && grid[r + 1][c] == 0) grid[r + 1][c] = color + 1;
                            if (c > 0 && grid[r][c - 1] == 0) grid[r][c - 1] = color + 1;
                            if (c < n - 1 && grid[r][c + 1] == 0) grid[r][c + 1] = color + 1;
                        }
                color++;
            }
        }

        boolean check(int[][] grid, int n, int r, int c) {
            return r > 0 && grid[r - 1][c] == 1
                    || c > 0 && grid[r][c - 1] == 1
                    || r + 1 < n && grid[r + 1][c] == 1
                    || c + 1 < n && grid[r][c + 1] == 1;
        }
    }

    class Solution2 {
        public int shortestBridge(int[][] grid) {
            int n = grid.length;
            LinkedList<Integer> q = new LinkedList<>();
            outer:
            for (int r = 0; r < n; r++)
                for (int c = 0; c < n; c++)
                    if (grid[r][c] == 1) {
                        dfs(grid, n, r, c, q);
                        break outer;
                    }

            int step = -1;
            while (q.size() > 0) {
                int sz = q.size();
                while (sz-- > 0) {
                    int code = q.poll();
                    int r = code >> 7, c = code & 127;
                    if (grid[r][c] == 1)
                        return step;

                    if (r > 0 && grid[r - 1][c] != -1) {
                        q.offer(encode(r - 1, c));
                        if (grid[r - 1][c] == 0) grid[r - 1][c] = -1;
                    }
                    if (c > 0 && grid[r][c - 1] != -1) {
                        q.offer(encode(r, c - 1));
                        if (grid[r][c - 1] == 0) grid[r][c - 1] = -1;
                    }
                    if (r + 1 < n && grid[r + 1][c] != -1) {
                        q.offer(encode(r + 1, c));
                        if (grid[r + 1][c] == 0) grid[r + 1][c] = -1;
                    }
                    if (c + 1 < n && grid[r][c + 1] != -1) {
                        q.offer(encode(r, c + 1));
                        if (grid[r][c + 1] == 0) grid[r][c + 1] = -1;
                    }
                }
                step++;
            }
            return 0;
        }

        void dfs(int[][] grid, int n, int r, int c, LinkedList<Integer> island) {
            if (r < 0 || c < 0 || r == n || c == n || grid[r][c] != 1) return;
            grid[r][c] = -1;

            boolean border = false;
            if (r > 0)
                if (grid[r - 1][c] == 0) border = true;
                else dfs(grid, n, r - 1, c, island);
            if (c > 0)
                if (grid[r][c - 1] == 0) border = true;
                else dfs(grid, n, r, c - 1, island);
            if (r + 1 < n)
                if (grid[r + 1][c] == 0) border = true;
                else dfs(grid, n, r + 1, c, island);
            if (c + 1 < n)
                if (grid[r][c + 1] == 0) border = true;
                else dfs(grid, n, r, c + 1, island);
            if (border) island.offer(encode(r, c));
        }

        int encode(int r, int c) {
            return (r << 7) | c;
        }
    }
}
