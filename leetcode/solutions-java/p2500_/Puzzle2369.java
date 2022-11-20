package p2500_;

/**
 * https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/description/
 */
public class Puzzle2369 {


    public static void main(String[] args) {
        Solution s = new Puzzle2369().new Solution();
        System.out.println(s.validPartition(new int[]{
                1, 1
        }));
    }

    class MySolution {
        public boolean validPartition(int[] nums) {
            int n = nums.length;
            boolean[] b = new boolean[n];
            for (int i = 1; i < n; i++) {
                if (nums[i] == nums[i - 1]) {
                    b[i] = i == 1 || b[i - 2] || (nums[i] == nums[i - 2] && (i == 2 || b[i - 3]));
                } else if (nums[i] - nums[i - 1] == 1) {
                    if (i > 1 && nums[i - 1] - nums[i - 2] == 1) {
                        b[i] = i == 2 || b[i - 3];
                    }
                }
            }
            return b[n - 1];
        }
    }

    class Solution {
        public boolean validPartition(int[] nums) {
            int n = nums.length, m = 4;
            int[] dp = new int[]{0, 0, 0, 1};
            for (int i = 0; i < n; ++i) {
                dp[i % m] = 0;
                if (i > 0 && nums[i] == nums[i - 1])
                    dp[i % m] |= dp[(i + 2) % m];
                if (i > 1 && nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2])
                    dp[i % m] |= dp[(i + 1) % m];
                if (i > 1 && nums[i] - 1 == nums[i - 1] && nums[i - 1] == nums[i - 2] + 1)
                    dp[i % m] |= dp[(i + 1) % m];
            }
            return dp[(n - 1) % m] > 0;
        }
    }
}
