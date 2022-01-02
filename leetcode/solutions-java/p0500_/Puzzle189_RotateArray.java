package p0500_;

// Rotate an array of n elements to the right by k steps.
//
// For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
//
// Note:
// Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
//
// Hint:
// Could you do it in-place with O(1) extra space?

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-array/
 */
public class Puzzle189_RotateArray {

    public static void main(String[] args) {
        Puzzle189_RotateArray p = new Puzzle189_RotateArray();
        Solution solution = p.new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        solution.rotate(nums, 7);
        System.out.println(Arrays.toString(nums));
    }

    public class Solution {
        public void rotate(int[] nums, int k) {
            if (k == 0 || nums.length <= 1 || k % nums.length == 0) return;

            k = k % nums.length;
            int times = findGcd(nums.length, k);

            int end = nums.length - k, start;
            int m, n = nums[end];
            for (int i = 0; i < times; i++) {
                start = i;
                while (true) {
                    m = nums[start];
                    nums[start] = n;
                    n = m;
                    if (start == end)
                        break;
                    start = (start + k) % nums.length;
                }
                ++end;
                if (end < nums.length) {
                    n = nums[end];
                }
            }
        }

        public int findGcd(int n, int m) {
            return (n == 0 || m == 0) ? n + m : findGcd(m, n % m);
        }
    }

    // O(n) time cost, no space cost
    public class Solution2 {
        public void rotate(int[] nums, int k) {
            if (nums.length <= 1 || k == 0) {
                return;
            }
            k = k % nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        public void reverse(int[] nums, int n, int m) {
            while (n < m) {
                nums[n] ^= nums[m];
                nums[m] ^= nums[n];
                nums[n++] ^= nums[m--];
            }
        }
    }
}
