package p0500_;

// Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
// Note:
// You are not suppose to use the library's sort function for this problem.
//
// Follow up:
// A rather straight forward solution is a two-pass algorithm using counting sort.
// First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
//
// Could you come up with an one-pass algorithm using only constant space?

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class Puzzle075_SortColors {

    public static void main(String[] args) {
        Puzzle075_SortColors p = new Puzzle075_SortColors();
        Solution s = p.new Solution();
        int[] arr = new int[]{1, 2, 2, 2, 2, 0, 0, 0, 1, 1};
        s.sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    public class Solution {
        public void sortColors(int[] nums) {
            int i0 = 0, i1 = 0, i2 = nums.length - 1;
            int i = 0;
            while (i <= i2) {
                if (nums[i] == 0) {
                    if (i > i1) {
                        nums[i] ^= nums[i1];
                        nums[i1] ^= nums[i];
                        nums[i] ^= nums[i1++];
                    } else {
                        i++;
                    }
                    i1 = Math.min(i, i1);
                } else if (nums[i] == 2 && i != i2) {
                    nums[i] ^= nums[i2];
                    nums[i2] ^= nums[i];
                    nums[i] ^= nums[i2--];
                } else {
                    i1 = Math.min(i1, i++);
                }
            }
        }
    }

    public class NeatSolution {
        public void sortColors(int[] nums) {
            int i0 = 0, i2 = nums.length - 1;
            for (int i = 0; i <= i2; i++) {
                while (nums[i] == 2 && i < i2) {
                    nums[i] ^= nums[i2];
                    nums[i2] ^= nums[i];
                    nums[i] ^= nums[i2--];
                }
                while (nums[i] == 0 && i > i0) {
                    nums[i] ^= nums[i0];
                    nums[i0] ^= nums[i];
                    nums[i] ^= nums[i0++];
                }
            }
        }
    }

}
