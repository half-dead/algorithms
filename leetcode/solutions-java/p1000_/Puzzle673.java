package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 *
 * @author half-dead
 */
public class Puzzle673 {

    public static void main(String[] args) {
        Solution s = new Puzzle673().new Solution();
        System.out.println(s.findNumberOfLIS(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3}));
    }

    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int len = nums.length, max = 1, res = 0;
            int[] dp = new int[len], cnt = new int[len];
            Arrays.fill(dp, 1);
            Arrays.fill(cnt, 1);
            for (int i = 1; i < len; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] > nums[j]) {
                        if (dp[j] + 1 > dp[i]) {
                            dp[i] = dp[j] + 1;
                            cnt[i] = cnt[j];
                        } else if (dp[j] + 1 == dp[i]) {
                            cnt[i] += cnt[j];
                        }
                        max = Math.max(max, dp[i]);
                    }
                }
            }
            for (int i = 0; i < len; i++) {
                if (dp[i] == max) res += cnt[i];
            }
            return res;
        }
    }
}
