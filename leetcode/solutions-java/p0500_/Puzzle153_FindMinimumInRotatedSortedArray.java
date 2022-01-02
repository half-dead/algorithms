package p0500_;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * @author half-dead
 */
public class Puzzle153_FindMinimumInRotatedSortedArray {
    class Solution {
        public int findMin(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[left] < nums[right]) {
                    return nums[left];
                } else if (nums[left] <= nums[mid]) {
                    left = mid + 1;
                } else if (nums[mid] <= nums[right]) {
                    right = mid;
                } else {
                    break;
                }
            }
            return nums[left];
        }
    }
}
