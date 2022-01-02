package p0500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/create-maximum-number/
 *
 * @author half-dead
 */
public class Puzzle321 {

    public static void main(String[] args) {
        Solution s = new Puzzle321().new Solution();
//        System.out.println(Arrays.toString(s.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5)));
//        System.out.println(Arrays.toString(s.maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5)));
//        System.out.println(Arrays.toString(s.maxNumber(new int[]{3, 9}, new int[]{8, 9}, 3)));
        System.out.println(Arrays.toString(s.maxNumber(new int[]{4, 9, 5}, new int[]{8, 7, 4}, 3)));
    }

    class Solution {
        public int[] maxNumber(int[] arr1, int[] arr2, int k) {
            int m = arr1.length, n = arr2.length;
            int[] res = new int[k];
            for (int left = 0, right = k; left <= k; left++, right--) {
                if (m < left || n < right) continue;

                int[] part1 = maxSubArray(arr1, left), part2 = maxSubArray(arr2, right);
                int[] merged = merge(part1, part2, k);
                if (isGreater(merged, 0, res, 0)) res = merged;
            }
            return res;
        }

        private int[] maxSubArray(int[] nums, int k) {
            int[] res = new int[k];
            for (int i = 0, j = 0, n = nums.length; i < n; i++) {
                while (j > 0 && nums[i] > res[j - 1] && n - i > k - j) j--;
                if (j < k) res[j++] = nums[i];
            }
            return res;
        }

        private int[] merge(int[] a, int[] b, int k) {
            int[] res = new int[k];
            for (int i = 0, j = 0, r = 0; r < k; r++) {
                res[r] = isGreater(a, i, b, j) ? a[i++] : b[j++];
            }
            return res;
        }

        private boolean isGreater(int[] a, int ai, int[] b, int bi) {
            int m = a.length, n = b.length, i = ai, j = bi;
            while (i < m && j < n && a[i] == b[j]) {
                i++;
                j++;
            }
            return j == n || (i < m && a[i] >= b[j]);
        }
    }

}
