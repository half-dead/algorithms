/*
https://leetcode.com/problems/product-of-array-except-self/description/

Given an array of n integers where n > 1, nums, return an array output such that output[i]
is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity?
(Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */

package p0500_;

import java.util.Arrays;

/**
 * @author half-dead
 */
public class Puzzle238_ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        Solution solution = new Puzzle238_ProductOfArrayExceptSelf().new Solution();
        int[] ints = solution.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));
    }

    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] res = new int[nums.length];
            int extra = 1;
            for (int i = 0; i < nums.length; i++) {
                res[i] = extra;
                extra *= nums[i];
            }
            extra = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                res[i] *= extra;
                extra *= nums[i];
            }
            return res;
        }
    }
}
