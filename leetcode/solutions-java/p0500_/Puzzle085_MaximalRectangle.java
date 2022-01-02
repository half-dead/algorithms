package p0500_;

/**
 * https://leetcode.com/problems/maximal-rectangle/
 *
 * @author half-dead
 */
public class Puzzle085_MaximalRectangle {
    public static void main(String[] args) {
        Puzzle085_MaximalRectangle p = new Puzzle085_MaximalRectangle();
        Solution s = p.new Solution();
        int area = s.maximalRectangle(new char[][]{
                "111111011111111".toCharArray(),
                "101101111111111".toCharArray(),
                "111111111111111".toCharArray(),
                "011111101110111".toCharArray(),
                "100111111110111".toCharArray(),
                "111111111111111".toCharArray(),
                "111011111110111".toCharArray(),
                "111100011111010".toCharArray(),
                "101100011110101".toCharArray(),
                "101111110111011".toCharArray(),
                "101111111111111".toCharArray(),
                "111011111111111".toCharArray(),
                "111000101111111".toCharArray(),
                "111111011111111".toCharArray(),
                "111111101111101".toCharArray(),
        });

        System.out.println(area);
    }

    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return 0;

            int max = 0;
            int rows = matrix.length, cols = matrix[0].length;
            int[] left = new int[cols], right = new int[cols], height = new int[cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
                }

                left[0] = -1;
                for (int j = 1; j < cols; j++) {
                    int idx = j - 1;
                    while (idx >= 0 && height[idx] >= height[j]) {
                        idx = left[idx];
                    }
                    left[j] = idx;
                }

                right[cols - 1] = cols;
                for (int j = cols - 2; j >= 0; j--) {
                    int idx = j + 1;
                    while (idx < cols && height[idx] >= height[j]) {
                        idx = right[idx];
                    }
                    right[j] = idx;
                }

                for (int j = 0; j < cols; j++) {
                    max = Math.max(max, (right[j] - left[j] - 1) * height[j]);
                }
            }
            return max;
        }
    }

}
