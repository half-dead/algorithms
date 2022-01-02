package p1000_;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/split-array-with-same-average/
 *
 * @author half-dead
 */
public class Puzzle805 {

    public static void main(String[] args) {
        Solution s = new Puzzle805().new Solution();
//        System.out.println(s.splitArraySameAverage(new int[]{2, 0, 5, 6, 16, 12, 15, 12, 4}));
        System.out.println(s.splitArraySameAverage(new int[]{73, 37, 34, 95, 4, 97, 22, 53, 55, 52, 46, 44, 71, 24, 26, 35, 96, 3}));
    }

    class Solution {
        public boolean splitArraySameAverage(int[] nums) {
            int n = nums.length, sum = 0, half = n / 2;
            for (int x : nums) sum += x;

            boolean possible = false;
            for (int i = 1; i < n; i++) {
                if (sum * i % n == 0) {
                    possible = true;
                    break;
                }
            }
            if (!possible) return false;

            boolean[][] dp = new boolean[sum + 1][half + 1];
            dp[0][0] = true;

            for (int x : nums) {
                for (int prev = sum; prev >= x; prev--) {
                    for (int i = 1; i <= half; i++) {
                        dp[prev][i] |= dp[prev - x][i - 1];
                    }
                }
            }

            for (int i = 1; i <= half; i++) {
                for (int j = 0; j <= sum; j++) {
                    if (dp[j][i] && j * n == sum * i) return true;
                }
            }
            return false;
        }
    }


}
