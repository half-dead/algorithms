package p2500_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author half-dead
 */
public class Puzzle2008 {

    // dp knapsack, O(MlogM) for sorting, O(N) for knapsack
    class Solution {
        public long maxTaxiEarnings(int n, int[][] rides) {

            Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));

            long[] dp = new long[n + 1];
            long temp = 0L;
            int pos = 0;
            for (int[] ride : rides) {
                int start = ride[0], end = ride[1], tip = ride[2];
                while (pos <= start) {
                    temp = Math.max(temp, dp[pos++]);
                }
                dp[end] = Math.max(dp[end], temp + tip + end - start);
            }

            for (long x : dp) temp = Math.max(temp, x);
            return temp;
        }
    }
}
