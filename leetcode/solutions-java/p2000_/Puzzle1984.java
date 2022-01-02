package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/submissions/
 *
 * @author half-dead
 */
public class Puzzle1984 {

    class Solution {
        public int minimumDifference(int[] nums, int k) {
            Arrays.sort(nums);
            int n = nums.length, res = nums[n - 1] - nums[0];
            for (int i = k - 1; i < n; i++) {
                res = Math.min(res, nums[i] - nums[i - k + 1]);
            }
            return res;
        }
    }
}
