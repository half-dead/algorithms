package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-array-according-to-given-pivot/
 *
 * @author half-dead
 */
public class Puzzle2161 {

    class Solution {
        public int[] pivotArray(int[] nums, int pivot) {
            int n = nums.length;

            int[] res = new int[n];
            Arrays.fill(res, pivot);
            for (int i = 0, j = 0; i < n; i++) {
                if (nums[i] < pivot) res[j++] = nums[i];
            }
            for (int i = n - 1, j = n - 1; i >= 0; i--) {
                if (nums[i] > pivot) res[j--] = nums[i];
            }
            return res;
        }
    }
}
