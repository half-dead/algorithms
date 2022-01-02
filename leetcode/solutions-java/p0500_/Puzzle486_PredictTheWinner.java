package p0500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/predict-the-winner
 *
 * @author half-dead
 */
public class Puzzle486_PredictTheWinner {

    public static void main(String[] args) {
        Solution s = new Puzzle486_PredictTheWinner().new Solution();
        System.out.println(s.PredictTheWinner(new int[]{1, 2, 1, 1, 1}));
//        DpSolution dps = new Puzzle486_PredictTheWinner().new DpSolution();
//        System.out.println(dps.PredictTheWinner(new int[]{1, 567, 1, 1, 99, 100}));
    }

    class Solution {
        public boolean PredictTheWinner(int[] nums) {
            return recur(nums, 0, nums.length - 1, 0, 0);
        }

        public boolean recur(int[] nums, int left, int right, int a, int b) {
            if (right - left < 2) {
                return true;
            }
            if (right - left == 2) {
                return nums[left + 1] + b < nums[right] + nums[left] + a;
            }
            return !recur(nums, left + 1, right, b, a + nums[left]) || !recur(nums, left, right - 1, b, a + nums[right]);
        }
    }

    class DpSolution {
        public boolean PredictTheWinner(int[] nums) {
            int[] dp = new int[nums.length];
            for (int i = 0; i < dp.length; i++) {
                for (int j = i; j >= 0; j--) {
                    if (j == i) {
                        dp[j] = nums[j];
                        System.out.println(Arrays.toString(dp));
                    } else {
                        int a = nums[j] - dp[j + 1];
                        int b = nums[i] - dp[j];
                        dp[j] = Math.max(a, b);
                        System.out.printf(Arrays.toString(dp) + "\t" + "a=" + a + ", b=" + b + "\n");
                    }
                }
                System.out.println("");
            }
            return dp[0] >= 0;
        }
    }

}
