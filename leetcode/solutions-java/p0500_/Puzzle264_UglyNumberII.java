package p0500_;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 *
 * @author half-dead
 */
public class Puzzle264_UglyNumberII {
    public static void main(String[] args) {
        Solution solution = new Puzzle264_UglyNumberII().new Solution();
        System.out.println(solution.nthUglyNumber(1691));
    }

    class Solution {
        public int nthUglyNumber(int n) {
            if (n == 0) return 0;

            int[] dp = new int[n];
            dp[0] = 1;
            int a = 2, b = 3, c = 5, i2 = 0, i3 = 0, i5 = 0;

            for (int i = 1; i < n; i++) {
                int next = Math.min(a, Math.min(b, c));
                dp[i] = next;
                if (next == a) a = 2 * dp[++i2];
                if (next == b) b = 3 * dp[++i3];
                if (next == c) c = 5 * dp[++i5];
            }
            return dp[n - 1];
        }
    }
}
