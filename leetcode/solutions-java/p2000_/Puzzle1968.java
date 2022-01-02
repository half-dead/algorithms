package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/
 *
 * @author half-dead
 */
public class Puzzle1968 {

    class Solution {
        public int[] rearrangeArray(int[] nums) {
            int n = nums.length, i = 0, j = n - 1;
            Arrays.sort(nums);
            int[] res = new int[n];
            for (int k = 0; k < n; ) {
                res[k++] = nums[i++];
                if (k < n) res[k++] = nums[j--];
            }
            return res;
        }
    }
}
