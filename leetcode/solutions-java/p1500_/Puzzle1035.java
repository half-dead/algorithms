package p1500_;

/**
 * https://leetcode.com/problems/uncrossed-lines/
 *
 * @author half-dead
 */
public class Puzzle1035 {
    class Solution {
        public int maxUncrossedLines(int[] a, int[] b) {
            int lenA = a.length, lenB = b.length;
            int[][] dp = new int[lenA + 1][lenB + 1];
            for (int i = 0; i < lenA; i++)
                for (int j = 0; j < lenB; j++)
                    dp[i + 1][j + 1] = a[i] == b[j] ? dp[i][j] + 1 : Math.max(dp[i + 1][j], dp[i][j + 1]);
            return dp[lenA][lenB];
        }
    }
}
