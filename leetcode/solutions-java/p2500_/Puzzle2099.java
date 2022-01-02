package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/
 *
 * @author half-dead
 */
public class Puzzle2099 {

    class Solution {
        public int[] maxSubsequence(int[] nums, int k) {
            int n = nums.length;
            int[][] temp = new int[n][2];
            for (int i = 0; i < n; i++) {
                temp[i][0] = nums[i];
                temp[i][1] = i;
            }
            Arrays.sort(temp, (a, b) -> a[0] - b[0]);
            Arrays.sort(temp, n - k, n, (a, b) -> a[1] - b[1]);

            int[] ans = new int[k];
            for (int i = n - k, j = 0; i < n; i++, j++) {
                ans[j] = temp[i][0];
            }
            return ans;
        }
    }
}
