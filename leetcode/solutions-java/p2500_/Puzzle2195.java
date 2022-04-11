package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/append-k-integers-with-minimal-sum/
 *
 * @author half-dead
 */
public class Puzzle2195 {
    class Solution {
        public long minimalKSum(int[] nums, int k) {
            long sum = (long) k * (k + 1) / 2;
            Arrays.sort(nums);
            for (int i = 0, n = nums.length; i < n; i++) {
                if ((i == 0 || nums[i] != nums[i - 1]) && nums[i] <= k) {
                    sum -= nums[i];
                    sum += ++k;
                }
            }
            return sum;
        }
    }
}
