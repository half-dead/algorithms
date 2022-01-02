package p0500_;

// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
// For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
//
// Note:
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.


import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class Puzzle283_MoveZeroes {

    public static void main(String[] args) {
        Puzzle283_MoveZeroes.Solution s = new Puzzle283_MoveZeroes().new Solution();
        int[] arr = new int[]{0, 1, 0, 2, 0, 3, 0, 4, 5, 6, 0, 0};
        s.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public class Solution {
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0)
                return;

            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != 0) nums[i++] = nums[j];
            }
            for (int j = i; j < nums.length; j++) {
                nums[j] = 0;
            }
        }
    }

    public class Solution2 {
        public void moveZeroes(int[] nums) {
            int i = 0, j = 1, len = nums.length;

            while (true) {
                while (i < len && nums[i] != 0) i++;

                j = i + 1;
                while (j < len && nums[j] == 0) j++;
                if (i >= len || j >= len) {
                    break;
                }
                if (nums[i] == 0 && nums[j] != 0) {
                    nums[i++] = nums[j];
                    nums[j--] = 0;
                }
            }

        }
    }
}
