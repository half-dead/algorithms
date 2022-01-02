package p2000_;

/**
 * https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
 *
 * @author half-dead
 */
public class Puzzle1886 {

    public static void main(String[] args) {
        Solution s = new Puzzle1886().new Solution();
        System.out.println(s.findRotation(new int[][]{
                {0, 0, 0}, {0, 1, 0}, {1, 1, 1}
        }, new int[][]{
                {1, 1, 1}, {0, 1, 0}, {0, 0, 0}
        }));
    }

    class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
            int cnt = 0;
            boolean eq = compare(mat, target);
            while (!eq && cnt++ < 3) {
                mat = rotate(mat);
                eq = compare(mat, target);
            }
            return eq;
        }

        boolean compare(int[][] a, int[][] b) {
            int n = a.length;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (a[i][j] != b[i][j])
                        return false;

            return true;
        }

        int[][] rotate(int[][] a) {
            int n = a.length;
            int[][] res = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    res[i][j] = a[j][n - 1 - i];

            return res;
        }
    }
}
