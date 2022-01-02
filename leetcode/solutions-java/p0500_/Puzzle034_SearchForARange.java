package p0500_;

// Given a sorted array of integers, find the starting and ending position of a given target value.
//
// Your algorithm's runtime complexity must be in the order of O(log n).
//
// If the target is not found in the array, return [-1, -1].
//
// For example,
//   Given [5, 7, 7, 8, 8, 10] and target value 8,
//   return [3, 4].

import java.util.Arrays;

/**
 * https://leetcode.com/problems/search-for-a-range/
 */
public class Puzzle034_SearchForARange {

    public static void main(String[] args) {
        Puzzle034_SearchForARange p = new Puzzle034_SearchForARange();
        Solution s = p.new Solution();
        int[] nums = new int[]{1, 2, 3};
        int[] range = s.searchRange(nums, 2);
        System.out.println(Arrays.toString(range));

        Solution2 s2 = p.new Solution2();
        int[] range2 = s2.searchRange(nums, 2);
        System.out.println(Arrays.toString(range2));
    }

    public class Solution {
        public int[] searchRange(int[] nums, int target) {
            int s = -1, e = -1;
            int ss = 0, se = nums.length - 1, es = 0, ee = nums.length - 1;
            while (ss <= se || es <= ee) {
                if (ss <= se) {
                    int sm = (ss + se) >> 1;
                    if (nums[sm] == target && (sm == 0 || nums[sm - 1] < target)) {
                        s = se = sm;
                        ss = sm + 1;
                        es = sm;
                    } else if (nums[sm] >= target) {
                        se = sm - 1;
                        if (nums[sm] > target) {
                            ee = sm - 1;
                        }
                    } else {
                        ss = sm + 1;
                        es = sm + 1;
                    }
                }
                if (es <= ee) {
                    int em = (es + ee) >> 1;
                    if (nums[em] == target && (em == nums.length - 1 || nums[em + 1] > target)) {
                        e = ee = em;
                        es = em + 1;
                        se = em;
                    } else if (nums[em] <= target) {
                        es = em + 1;
                        if (nums[em] < target) {
                            ss = em + 1;
                        }
                    } else {
                        ee = em - 1;
                        se = em - 1;
                    }
                }

            }
            return new int[]{s, e};
        }
    }

    public class Solution2 {
        public int[] searchRange(int[] nums, int target) {
            int i = 0, j = nums.length - 1;
            int[] result = new int[]{-1, -1};
            while (i < j) {
                int mid = (i + j) >> 1;
                if (nums[mid] < target) i = mid + 1;
                else j = mid;
            }
            if (nums[i] != target) return result;
            else result[0] = i;
            j = nums.length - 1;
            while (i < j) {
                int mid = ((i + j) >> 1) + 1;
                if (nums[mid] > target) j = mid - 1;
                else i = mid;
            }
            result[1] = j;
            return result;
        }
    }
}
