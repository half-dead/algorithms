package p2000_;

/**
 * https://leetcode.com/problems/find-a-peak-element-ii/
 *
 * @author half-dead
 */
public class Puzzle1901 {

    public static void main(String[] args) {
        Solution s = new Puzzle1901().new Solution();
        s.findPeakGrid(new int[][]{
//                {1, 2, 3, 4, 5, 6, 7, 8}, {2, 3, 4, 5, 6, 7, 8, 9}, {3, 4, 5, 6, 7, 8, 9, 10}, {4, 5, 6, 7, 8, 9, 10, 11}
                {1,4},{3,2}
        });
    }

    class Solution {
        public int[] findPeakGrid(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            int lo = 0, hi = n - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                int max = mat[0][mid], r = 0, c = mid;
                for (int j = Math.max(0, mid - 1); j <= Math.min(mid + 1, n - 1); j++) {
                    for (int i = 0; i < m; i++) {
                        if (mat[i][j] > max) {
                            max = mat[i][j];
                            r = i;
                            c = j;
                        }
                    }
                }
                if (c == mid)
                    return new int[]{r, c};
                else if (c > mid)
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
            return new int[]{0, 0};
        }
    }
}
