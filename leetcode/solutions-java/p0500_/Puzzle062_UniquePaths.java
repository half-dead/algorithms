/*
https://leetcode.com/problems/unique-paths/description/

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?

Above is a 7 x 3 grid. How many possible unique paths are there?
Note: m and n will be at most 100.

Example 1:
    Input: m = 3, n = 2
    Output: 3
    Explanation:
    From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
    1. Right -> Right -> Down
    2. Right -> Down -> Right
    3. Down -> Right -> Right
Example 2:
    Input: m = 7, n = 3
    Output: 28
 */

package p0500_;

/**
 * @author half-dead
 */
public class Puzzle062_UniquePaths {

    public static void main(String[] args) {
        Solution s = new Puzzle062_UniquePaths().new Solution();
        System.out.println(s.uniquePaths(15, 15));
    }

    // dp
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    // arithmatic
    class Solution2 {
        public int uniquePaths(int m, int n) {
            int totalPath = m + n - 2;
            int down = m - 1;
            int right = n - 1;
            if (down == 0 || right == 0) {
                return 1;
            }
            int count = Math.min(down, right);
            long result = 1;
            for (int i = 1; i <= count; i++) {
                result *= totalPath--;
                result /= i;
            }
            return (int) result;
        }
    }
}
