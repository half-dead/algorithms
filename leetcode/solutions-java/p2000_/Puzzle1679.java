package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/
 *
 * @author half-dead
 */
public class Puzzle1679 {
    class Solution {
        public int maxOperations(int[] nums, int k) {
            Arrays.sort(nums);
            int i = 0, j = nums.length - 1, res = 0;
            while (i < j) {
                int sum = nums[i] + nums[j];
                if (sum > k) {
                    j--;
                } else if (sum < k) {
                    i++;
                } else {
                    i++;
                    j--;
                    res++;
                }
            }
            return res;
        }
    }
}
