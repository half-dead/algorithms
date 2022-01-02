package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/
 *
 * @author half-dead
 */
public class Puzzle1589 {

    public static void main(String[] args) {
        Solution s = new Puzzle1589().new Solution();
        System.out.println(s.maxSumRangeQuery(new int[]{1, 2, 3, 4, 5}, new int[][]{{0, 1}, {1, 3}}));
    }

    class Solution {
        public int maxSumRangeQuery(int[] nums, int[][] requests) {
            int n = nums.length, mod = (int) 1e9 + 7;

            int[] freqs = new int[n];
            for (int[] req : requests) {
                freqs[req[0]]++;
                if (req[1] + 1 < n) freqs[req[1] + 1]--;
            }

            for (int i = 1; i < n; i++) freqs[i] += freqs[i - 1];


            Arrays.sort(freqs);
            Arrays.sort(nums);

            long sum = 0L;
            for (int i = n - 1; i >= 0; i--) sum += ((long) freqs[i] * nums[i]);
            return (int) (sum % mod);
        }
    }
}
