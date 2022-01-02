package p1000_;

/**
 * https://leetcode.com/problems/largest-sum-of-averages/
 *
 * @author half-dead
 */
public class Puzzle813 {
    public static void main(String[] args) {
        Solution s = new Puzzle813().new Solution();
        System.out.println(s.largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3));
    }

    // Bottom-up DP, O(K*N^2) time, O(N) space
    class Solution {
        public double largestSumOfAverages(int[] nums, int k) {
            int n = nums.length;
            double[] prefixSum = new double[n + 1];
            for (int i = 0; i < n; i++) prefixSum[i + 1] = prefixSum[i] + nums[i];

            double[] dp = new double[n], next;
            for (int i = 0; i < n; i++)
                dp[i] = (prefixSum[n] - prefixSum[i]) / (n - i);

            for (int p = 2; p <= k; p++) {
                next = new double[n];
                for (int i = 0; i < n; i++) {
                    double max = 0.0D;
                    // try every possible position to partition[i, n-1] to two parts
                    for (int j = i; j < n - 1; j++) {
                        max = Math.max(max, (prefixSum[j + 1] - prefixSum[i]) / (j - i + 1) + dp[j + 1]);
                    }
                    next[i] = max;
                }
                dp = next;
            }
            return dp[0];
        }
    }
}
