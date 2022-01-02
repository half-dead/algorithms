package p1000_;

import util.Print;

/**
 * https://leetcode.com/problems/sort-an-array/
 *
 * @author half-dead
 */
public class Puzzle912_SortAnArray {

    public static void main(String[] args) {
        Solution s = new Puzzle912_SortAnArray().new Solution();
        int[] arr2 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        s.quickSelect(arr2, 0, arr2.length - 1, 9);
        Print.pt(arr2);

    }

    class Solution {
        public int[] sortArray(int[] nums) {
            quicksort(nums, 0, nums.length - 1);
            return nums;
        }

        public void quicksort(int[] nums, int from, int to) {
            if (from >= to) return;

            int pivot = nums[(from + to) / 2];
            int left = from, right = to;
            while (left <= right) {
                while (nums[left] < pivot) left++;
                while (nums[right] > pivot) right--;
                if (left <= right) {
                    if (left != right) {
                        int temp = nums[left];
                        nums[left] = nums[right];
                        nums[right] = temp;
                    }
                    left++;
                    right--;
                }
            }

            quicksort(nums, from, left - 1);
            quicksort(nums, left, to);
        }

        private void quickSelect(int[] costs, int start, int end, int n) {
            if (end < start) return;

            int i = start - 1, j = start - 1, pivot = end;
            while (j++ < pivot) {
                if (costs[j] <= costs[pivot]) {
                    int temp = costs[j];
                    costs[j] = costs[++i];
                    costs[i] = temp;
                }
            }
            if (i == n) return;
            else if (i > n) quickSelect(costs, start, i - 1, n);
            else quickSelect(costs, i + 1, end, n);
        }
    }
}
