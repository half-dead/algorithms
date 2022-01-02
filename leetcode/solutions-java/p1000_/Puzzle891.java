package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sum-of-subsequence-widths/
 *
 * @author half-dead
 */
public class Puzzle891 {
    public static void main(String[] args) {
        Solution s = new Puzzle891().new Solution();
        System.out.println(s.sumSubseqWidths(new int[]{2, 1, 3}));
    }

    // sort + math
    class Solution {
        public int sumSubseqWidths(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length, mod = (int) 1e9 + 7;

            int[] d = new int[n];
            // callculate the difference of any two adjcent number.
            for (int i = 1; i < n; i++) d[i] = nums[i] - nums[i - 1];

            // the number of subsequences of an array of length i
            // [0, 1, 3, 7, 15......]
            long[] powers = new long[n + 1];
            powers[1] = 1;
            for (int i = 2; i <= n; i++) powers[i] = (powers[i - 1] * 2 + 1) % mod;

            long res = 0;
            for (int i = 1; i < n; i++) {
                if (d[i] == 0) continue;
                // count of subsequences containing the difference d[i] both directly and undirectly
                // for example, given arr = [1, 2, 3], d = [0, 1, 1]
                // d[1] is contained in subsequences: {1,2}, {1,3}, {1,2,3}
                // d[2] is contained in subsequences: {1,3}, {2,3}, {1,2,3}
                long times = (powers[i] * powers[n - i]) % mod;
                res = (res + d[i] * times) % mod;
            }
            return (int) res;
        }
    }
}
