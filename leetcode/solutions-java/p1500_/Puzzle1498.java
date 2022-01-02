package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
 *
 * @author half-dead
 */
public class Puzzle1498 {

    public static void main(String[] args) {
        Solution s = new Puzzle1498().new Solution();
        System.out.println(s.numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));
    }

    class Solution {
        public int numSubseq(int[] nums, int target) {
            int len = nums.length, mod = (int) 1e9 + 7, left = 0, right = len - 1, res = 0;

            // pre-compute the number of subarrays(including empty) of an array of length 0..len;
            int[] powers = new int[len];
            powers[0] = 1;
            for (int i = 1; i < len; i++) powers[i] = (powers[i - 1] * 2) % mod;

            // sort the array, then we could apply two-pointer approach
            Arrays.sort(nums);

            while (left <= right) {
                if (nums[left] + nums[right] > target)
                    right--;
                else
                    // number of subarrays that start with the element nums[left]
                    res = (res + powers[right - left++]) % mod;
            }
            return res;
        }
    }
}
