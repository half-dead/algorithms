package p0500_;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 *
 * @author half-dead
 */
public class Puzzle416_PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Puzzle416_PartitionEqualSubsetSum p = new Puzzle416_PartitionEqualSubsetSum();
        Solution s = p.new Solution();
        System.out.println(s.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(s.canPartition(new int[]{2, 2, 3, 5}));
    }

    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int n : nums) sum += n;
            if (sum % 2 != 0) return false;

            int len = (sum >>>= 1) + 1;
            boolean[] dp = new boolean[len];
            dp[0] = true;
            for (int n : nums) {
                if (n > sum) return false;
                else if (n == sum) return true;
                else {
                    for (int i = sum; i >= n; i--) {
                        dp[i] |= dp[i - n];
                        if (i == sum && dp[i]) return true;
                    }
                }
            }
            return dp[sum];
        }
    }

}
