package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/
 *
 * @author half-dead
 */
public class Puzzle2294 {

    class Solution {
        public int partitionArray(int[] nums, int k) {
            Arrays.sort(nums);
            int i = 1, n = nums.length, res = 1, prev = nums[0];
            while (i < n) {
                if (nums[i] - prev > k) {
                    res++;
                    prev = nums[i];
                }
                i++;
            }
            return res;
        }
    }
}
