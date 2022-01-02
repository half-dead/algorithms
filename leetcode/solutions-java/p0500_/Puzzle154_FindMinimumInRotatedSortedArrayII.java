package p0500_;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * @author half-dead
 */
public class Puzzle154_FindMinimumInRotatedSortedArrayII {
    class Solution {
        public int findMin(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[left] < nums[right]) {
                    break;
                } else if (nums[left] < nums[mid]) {
                    left = mid + 1;
                } else if (nums[left] > nums[mid]) {
                    left++;
                    right = mid;
                } else {
                    left++;
                }
            }
            return nums[left];
        }
    }
}
