package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/k-radius-subarray-averages/
 *
 * @author half-dead
 */
public class Puzzle2090 {

    class Solution {
        public int[] getAverages(int[] nums, int k) {
            int n = nums.length, range = 2 * k + 1;

            int[] res = new int[n];
            Arrays.fill(res, -1);
            if (n < range) return res;

            long sum = 0;
            for (int i = 0; i < 2 * k; i++) sum += nums[i];

            for (int i = k; i < n - k; i++) {
                sum += nums[i + k];
                res[i] = (int) (sum / range);
                sum -= nums[i - k];
            }
            return res;
        }
    }
}
