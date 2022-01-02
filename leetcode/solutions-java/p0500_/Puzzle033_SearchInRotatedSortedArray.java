package p0500_;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * @author half-dead
 */
public class Puzzle033_SearchInRotatedSortedArray {

    public static void main(String[] args) {
        Puzzle033_SearchInRotatedSortedArray p = new Puzzle033_SearchInRotatedSortedArray();
        Solution solution = p.new Solution();
        int index = solution.search(new int[]{1}, 0);
        System.out.println(index);
    }

    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 0) {
                return -1;
            }

            if (nums[0] <= nums[nums.length - 1]) {
                return binarySearch(target, nums, 0, nums.length - 1);
            }

            int start = 0, end = nums.length - 1, mid = -1;
            while (start <= end) {
                mid = (start + end) / 2;
                if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                    break;
                } else if (nums[mid] < nums[0]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            if (target >= nums[0] && target <= nums[mid]) {
                return binarySearch(target, nums, 0, mid);
            } else if (target >= nums[mid + 1] && target <= nums[nums.length - 1]) {
                return binarySearch(target, nums, mid + 1, nums.length - 1);
            } else {
                return -1;
            }
        }

        public int binarySearch(int target, int[] nums, int start, int end) {
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return -1;
        }
    }

    class NeatSolution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int n = nums.length;
            int left = 0, right = n - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) return mid;
                if (nums[mid] < nums[right]) {
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            return -1;
        }
    }
}
