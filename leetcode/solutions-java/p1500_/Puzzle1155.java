package p1500_;

/**
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 *
 * @author half-dead
 */
public class Puzzle1155 {

    public static void main(String[] args) {
        Solution s = new Puzzle1155().new Solution();
        System.out.println(s.numRollsToTarget(5, 11, 54));
    }

    class Solution {
        public int numRollsToTarget(int d, int f, int target) {
            if (d > target || d * f < target) return 0;
            if (d == 1) return 1;

            int mod = 1000000007;
            long[][] dp = new long[d + 1][target + 1];
            for (int v = 1; v <= Math.min(f, target); v++) dp[1][v] = 1;
            for (int i = 2; i <= d; i++) {
                for (int t = i - 1; t <= target; t++) {
                    for (int v = 1; v <= f; v++) {
                        int nv = t + v;
                        if (nv > target) break;
                        dp[i][nv] = (dp[i][nv] + dp[i - 1][t]) % mod;
                    }
                    if (dp[i - 1][t] == 0) break;
                }
            }
            return (int) (dp[d][target] % mod);
        }
    }
}
