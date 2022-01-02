package p0500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * @author half-dead
 */
public class Puzzle300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Puzzle300_LongestIncreasingSubsequence p = new Puzzle300_LongestIncreasingSubsequence();
        Solution s = p.new Solution();
        System.out.println(s.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    class Solution2 {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) return 0;
            int[] dp = new int[nums.length];
            dp[0] = 1;
            for (int i = 1; i < nums.length; i++)
                for (int j = 0; j < i; j++)
                    dp[i] = Math.max(dp[i], nums[i] > nums[j] ? dp[j] + 1 : 1);
            int max = 0;
            for (int n : dp) max = Math.max(n, max);
            return max;
        }
    }

    public class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int len = 0;
            for (int num : nums) {
                int i = Arrays.binarySearch(dp, 0, len, num);
                if (i < 0) i = -i - 1;
                dp[i] = num;
                if (i == len) len++;
            }
            return len;
        }
    }
}
