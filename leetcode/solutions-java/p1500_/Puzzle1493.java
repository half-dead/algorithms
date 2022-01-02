package p1500_;

/**
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 *
 * @author half-dead
 */
public class Puzzle1493 {

    class Solution {
        public int longestSubarray(int[] nums) {
            int zeros = 0, left = 0, right = 0, len = nums.length;
            while (right < len) {
                if (nums[right] == 0) zeros++;
                if (zeros > 1 && nums[left++] == 0) zeros--;
                right++;
            }
            return right - left - 1;
        }
    }
}
