package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/cherry-pickup/
 *
 * @author half-dead
 */
public class Puzzle741_CherryPickup {
    public static void main(String[] args) {
        Puzzle741_CherryPickup p = new Puzzle741_CherryPickup();
        Solution s = p.new Solution();
//        System.out.println(s.cherryPickup(new int[][]{
//                {0, 1, -1},
//                {1, 0, -1},
//                {1, 1, 1},
//        })); // 5
//        System.out.println(s.cherryPickup(new int[][]{
//                {1, 1, -1},
//                {1, -1, 1},
//                {-1, 1, 1},
//        })); // 0
//        System.out.println(s.cherryPickup(new int[][]{
//                {1, 1, 1, 1, 0, 0, 0},
//                {0, 0, 0, 1, 0, 0, 0},
//                {0, 0, 0, 1, 0, 0, 1},
//                {1, 0, 0, 1, 0, 0, 0},
//                {0, 0, 0, 1, 0, 0, 0},
//                {0, 0, 0, 1, 0, 0, 0},
//                {0, 0, 0, 1, 1, 1, 1},
//        })); // 15
//        System.out.println(s.cherryPickup(new int[][]{
//                {1, -1, -1, -1, -1},
//                {1, 0, 1, -1, -1},
//                {0, -1, 1, 0, 1},
//                {1, 0, 1, 1, 0},
//                {-1, -1, -1, 1, 1}
//        })); // 10
        System.out.println(s.cherryPickup(new int[][]{
                {0, 1, 1, 0, 0},
                {1, 1, 1, 1, 0},
                {-1, 1, 1, 1, -1},
                {0, 1, 1, 1, 0},
                {1, 0, -1, 0, 0}
        })); // 11

    }

    class Solution {
        public int cherryPickup(int[][] grid) {
            int n = grid.length;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    int left = 0, up = 0, leftup = 0;
                    if (j > 0) left = dp[i][j - 1];
                    if (i > 0) up = dp[i - 1][j];
                    if (i > 0 && j > 0) {
                        int r = i - 1, c = j - 1;
                        while (r >= 0 && c >= 0 && (leftup = dp[r][c]) < 0) {
                            r--;
                            c--;
                        }
                    }

                    if (left < 0 && up < 0) dp[i][j] = -1;
                    else if (left < 0) dp[i][j] = grid[i][j] == -1 ? -1 : grid[i][j] + up;
                    else if (up < 0) dp[i][j] = grid[i][j] == -1 ? -1 : grid[i][j] + left;
                    else dp[i][j] = grid[i][j] == -1 ? -1 : (left + up - Math.max(leftup, 0) + grid[i][j]);
                }

            print(dp);
            return Math.max(dp[n - 1][n - 1], 0);
        }

        private void print(int[][] dp) {
            for (int[] ints : dp) {
                System.out.println(Arrays.toString(ints));
            }
        }
    }
}
