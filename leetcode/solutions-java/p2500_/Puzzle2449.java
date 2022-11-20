package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-arrays-similar/
 */
public class Puzzle2449 {

    public static void main(String[] args) {
        Solution s = new Puzzle2449().new Solution();
        System.out.println(s.makeSimilar(new int[]{
                8, 12, 6
        }, new int[]{
                2, 14, 10
        }));
    }

    // sort by (parity, value), greedy
    class Solution {
        public long makeSimilar(int[] nums, int[] target) {
            int n = nums.length, even = sortByParity(nums);
            sortByParity(target);

            Arrays.sort(nums, 0, even);
            Arrays.sort(target, 0, even);

            if (even < n) {
                Arrays.sort(nums, even, n);
                Arrays.sort(target, even, n);
            }

            long result = 0L;
            for (int i = 0; i < n; i++) {
                if (nums[i] == target[i]) continue;

                if (nums[i] > target[i]) {
                    result += (nums[i] - target[i]) / 2;
                }
            }
            return result;
        }

        private int sortByParity(int[] nums) {
            int i = 0, j = nums.length - 1;
            while (i <= j) {
                if (nums[i] % 2 == 0) {
                    i++;
                    continue;
                }
                if (nums[j] % 2 != 0) {
                    j--;
                    continue;
                }

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            return i;
        }
    }
}

