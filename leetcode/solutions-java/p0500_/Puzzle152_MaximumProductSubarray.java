package p0500_;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * @author half-dead
 */
public class Puzzle152_MaximumProductSubarray {
    public static void main(String[] args) {
        Puzzle152_MaximumProductSubarray p = new Puzzle152_MaximumProductSubarray();
        Solution s = p.new Solution();
        System.out.println(s.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(s.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(s.maxProduct(new int[]{-2, 3, 4, -1}));
    }

    // O(1) space dp
    class Solution {
        public int maxProduct(int[] nums) {
            int max = nums[0], min = max, ans = max;
            for (int i = 1; i < nums.length; i++) {
                int p1 = nums[i] * max, p2 = nums[i] * min;
                max = Math.max(nums[i], Math.max(p1, p2));
                min = Math.min(nums[i], Math.min(p1, p2));
                ans = Math.max(max, ans);
            }
            return ans;
        }
    }

    // O(n) space dp
    class Solution2 {
        public int maxProduct(int[] nums) {
            int[][] dp = new int[nums.length][2];
            for (int i = 0; i < nums.length; i++) dp[i][0] = dp[i][1] = nums[i];
            for (int i = 1; i < dp.length; i++) {
                int p1 = nums[i] * dp[i - 1][0], p2 = nums[i] * dp[i - 1][1];
                dp[i][0] = Math.max(nums[i], Math.max(p1, p2));
                dp[i][1] = Math.min(nums[i], Math.min(p1, p2));
            }
            int max = nums[0];
            for (int[] d : dp) {
                max = Math.max(max, Math.max(d[0], d[1]));
            }
            return max;
        }
    }

}
