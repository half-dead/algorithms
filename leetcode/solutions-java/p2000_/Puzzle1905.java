package p2000_;

/**
 * https://leetcode.com/problems/count-sub-islands/
 *
 * @author half-dead
 */
public class Puzzle1905 {

    public static void main(String[] args) {
        Solution s = new Puzzle1905().new Solution();
        System.out.println(s.countSubIslands(new int[][]{
                {1, 0, 1, 0, 1}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {1, 0, 1, 0, 1}
        }, new int[][]{
                {0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {0, 1, 0, 1, 0}, {0, 1, 0, 1, 0}, {1, 0, 0, 0, 1}
        }));
    }

    // 其实不会存在这种情况：g2中的某个岛屿的cell对应到多个g1中的岛
    class Solution {
        int m, n;

        public int countSubIslands(int[][] p, int[][] q) {
            m = p.length;
            n = p[0].length;

            int res = 0;
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (q[i][j] == 1 && dfs(p, q, i, j))
                        res++;
            return res;
        }

        boolean dfs(int[][] p, int[][] q, int r, int c) {
            if (r < 0 || r == m || c < 0 || c == n || q[r][c] != 1)
                return true;

            q[r][c] = 0;
            return dfs(p, q, r + 1, c) & dfs(p, q, r - 1, c) & dfs(p, q, r, c + 1) & dfs(p, q, r, c - 1) & p[r][c] == 1;
        }
    }

}
