package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/flood-fill/
 *
 * @author half-dead
 */
public class Puzzle733_FloodFill {
    public static void main(String[] args) {
        Puzzle733_FloodFill p = new Puzzle733_FloodFill();
        Solution s = p.new Solution();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        s.floodFill(image, 1, 1, 2);
        System.out.println(Arrays.deepToString(image));
    }

    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int rows = image.length, cols = image[0].length;
            dfs(image, rows, cols, sr, sc, image[sr][sc], newColor);
            return image;
        }

        void dfs(int[][] image, int rows, int cols, int r, int c, int color1, int color2) {
            if (image[r][c] != color1 || image[r][c] == color2) return;
            image[r][c] = color2;
            if (r > 0) dfs(image, rows, cols, r - 1, c, color1, color2);
            if (c > 0) dfs(image, rows, cols, r, c - 1, color1, color2);
            if (r + 1 < rows) dfs(image, rows, cols, r + 1, c, color1, color2);
            if (c + 1 < cols) dfs(image, rows, cols, r, c + 1, color1, color2);
        }
    }
}
