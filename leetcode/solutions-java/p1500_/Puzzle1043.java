package p1500_;

/**
 * https://leetcode.com/problems/partition-array-for-maximum-sum/
 *
 * @author half-dead
 */
public class Puzzle1043 {

    public static void main(String[] args) {
        Solution s = new Puzzle1043().new Solution();
//        System.out.println(s.maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
        System.out.println(s.maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4));
    }

    class Solution {
        public int maxSumAfterPartitioning(int[] A, int K) {
            int len = A.length;
            int[] dp = new int[len + 1];
            for (int i = 1; i <= len; i++) {
                int max = A[i - 1];
                dp[i] = dp[i - 1] + max;
                for (int from = i - 2, to = Math.max(i - K, 0); from >= to; from--) {
                    max = Math.max(A[from], max);
                    dp[i] = Math.max(dp[i], max * Math.min(i - from, K) + dp[Math.max(0, from)]);
                }
            }
            return dp[len];
        }
    }
}
