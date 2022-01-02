package p1000_;

/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 *
 * @author half-dead
 */
public class Puzzle674_LongestContinuousIncreasingSubsequence {
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int max = 1;
            for (int i = 0; i < nums.length; i++) {
                int j = i, k = 1;
                while (j < nums.length - 1 && nums[j] < nums[j + 1]) {
                    j++;
                    k++;
                }
                if (max < k) {
                    max = k;
                }
                i = j;
            }
            return max;
        }
    }
}
