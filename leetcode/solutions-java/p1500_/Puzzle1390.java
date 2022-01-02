package p1500_;

/**
 * @author half-dead
 */
public class Puzzle1390 {

    class Solution {
        public int sumFourDivisors(int[] nums) {
            int max = 0;
            for (int n : nums) max = Math.max(max, n);

            int limit = max + 1;
            int[][] dp = new int[limit][2];
            for (int i = 1; i < limit; i++) {
                for (int j = i; j < limit; j++) {
                    int p = i * j;
                    if (p >= limit || p <= 0) break;

                    if (dp[p][1] > 4) continue;

                    dp[p][0] += i == j ? i : (i + j);
                    dp[p][1] += i == j ? 1 : 2;
                }
            }

            int res = 0;
            for (int n : nums) {
                if (dp[n][1] == 4) res += dp[n][0];
            }
            return res;
        }
    }
}
