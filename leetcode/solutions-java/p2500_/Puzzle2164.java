package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-even-and-odd-indices-independently/
 *
 * @author half-dead
 */
public class Puzzle2164 {

    public static void main(String[] args) {
        Solution s = new Puzzle2164().new Solution();
        System.out.println(Arrays.toString(s.sortEvenOdd(new int[]{4, 1, 2, 3})));
    }

    class Solution {
        public int[] sortEvenOdd(int[] nums) {
            sort(nums, 0);
            sort(nums, 1);
            return nums;
        }

        void sort(int[] nums, int begin) {
            int n = nums.length, m = (n + 1) / 2;
            int[] temp = new int[m];
            for (int i = begin, j = 0; i < n; i += 2, j++) {
                temp[j] = nums[i];
            }
            Arrays.sort(temp);
            for (int i = begin, j = begin == 0 ? 0 : m - 1; i < n; i += 2, j = begin == 0 ? j + 1 : j - 1) {
                nums[i] = temp[j];
            }
        }
    }
}
