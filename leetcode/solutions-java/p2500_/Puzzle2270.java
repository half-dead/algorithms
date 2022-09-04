package p2500_;

/**
 * https://leetcode.com/problems/number-of-ways-to-split-array/
 *
 * @author half-dead
 */
public class Puzzle2270 {
    class Solution {
        public int waysToSplitArray(int[] nums) {
            long total = 0L, curr = 0L;
            for (int v : nums) total += v;

            int res = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                curr += nums[i];
                total -= nums[i];
                if (curr >= total) {
                    res++;
                }
            }
            return res;
        }
    }
}
