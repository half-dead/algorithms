package p2000_;

/**
 * https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
 *
 * @author half-dead
 */
public class Puzzle1685 {

    // prefix sum
    class Solution {
        public int[] getSumAbsoluteDifferences(int[] nums) {
            int n = nums.length;
            int[] ps = new int[n + 1], res = new int[n];
            for (int i = 0; i < n; i++) ps[i + 1] = ps[i] + nums[i];

            for (int i = 0; i < n; i++) {
                int left = nums[i] * i - ps[i];
                int right = (ps[n] - ps[i]) - nums[i] * (n - i);
                res[i] = left + right;
            }
            return res;
        }
    }
}
