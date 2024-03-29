package p0500_;

// Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
// You may assume no duplicates in the array.
//
// Here are few examples.
//   [1,3,5,6], 5 �� 2
//   [1,3,5,6], 2 �� 1
//   [1,3,5,6], 7 �� 4
//   [1,3,5,6], 0 �� 0

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class Puzzle035_SearchInsertPosition {
    public class Solution {
        public int searchInsert(int[] nums, int target) {
            int s = 0, e = nums.length - 1;
            while (s <= e) {
                int mid = (s + e) >> 1;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
            return s;
        }
    }
}
