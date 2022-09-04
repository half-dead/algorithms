package util;

import java.util.Arrays;

/**
 * @author half-dead
 */
class DivideSticksDP {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }
        if (totalSum % k != 0) return false;
        int targetSum = totalSum / k;

        int[] sum = new int[1 << n];
        for (int s = 0; s < (1 << n); s++) {
            for (int i = 0; i < n; i++) {
                if (((s >>> i) & 1) != 0) {
                    sum[s] += nums[i];
                }
            }
        }

        int mask = (1 << n) - 1;
        boolean[][] dp = new boolean[k + 1][1 << n];
        for (int i = 0; i <= k; i++) Arrays.fill(dp[i], false);

        dp[0][0] = true;
        for (int i = 0; i < k; i++) {
            for (int s = 0; s < (1 << n); s++) {
                if (!dp[i][s]) continue;
                int remain = ~s & mask;
                for (int sub = remain; sub > 0; sub = (sub - 1) & remain) {
                    if (sum[sub] == targetSum) {
                        dp[i + 1][s | sub] = true;
                    }
                }
            }
        }
        return dp[k][(1 << n) - 1];
    }
}
