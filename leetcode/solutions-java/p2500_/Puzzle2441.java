package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/
 */
public class Puzzle2441 {
    class Solution {
        public int findMaxK(int[] nums) {
            Arrays.sort(nums);
            int i = 0, j = nums.length - 1;
            while (i < j) {
                if (-nums[i] == nums[j]) {
                    return nums[j];
                } else if (-nums[i] < nums[j]) {
                    j--;
                } else {
                    i++;
                }
            }
            return -1;
        }
    }
}
