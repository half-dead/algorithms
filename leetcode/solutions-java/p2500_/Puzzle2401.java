package p2500_;

/**
 * https://leetcode.com/problems/longest-nice-subarray/
 *
 * @author half-dead
 */
public class Puzzle2401 {

    // sliding window
    class Solution {
        public int longestNiceSubarray(int[] nums) {
            int temp = 0, res = 0, left = 0, right = 0;
            while (right < nums.length) {
                if ((temp & nums[right]) == 0) {
                    temp |= nums[right++];
                    res = Math.max(res, right - left);
                } else {
                    temp -= nums[left++];
                }
            }
            return res;
        }
    }
}
