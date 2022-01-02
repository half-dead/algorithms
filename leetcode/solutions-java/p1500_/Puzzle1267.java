package p1500_;

/**
 * https://leetcode.com/problems/count-servers-that-communicate/
 *
 * @author half-dead
 */
public class Puzzle1267 {
    public static void main(String[] args) {
        Solution s = new Puzzle1267().new Solution();
        System.out.println(s.countServers(new int[][]{{1, 0}, {0, 1}}));
    }

    class Solution {
        public int countServers(int[][] grid) {
            int rows = grid.length, cols = grid[0].length, res = 0;
            int[] cr = new int[rows], cc = new int[cols];
            for (int r = 0; r < rows; r++)
                for (int c = 0; c < cols; c++)
                    if (grid[r][c] == 1) {
                        cr[r]++;
                        cc[c]++;
                    }
            for (int r = 0; r < rows; r++)
                for (int c = 0; c < cols; c++)
                    if (grid[r][c] == 1 && (cr[r] > 1 || cc[c] > 1))
                        res++;
            return res;
        }
    }
}
