package p2500_;

/**
 * https://leetcode.com/problems/number-of-zero-filled-subarrays/
 *
 * @author half-dead
 */
public class Puzzle2348 {

    class Solution {
        public long zeroFilledSubarray(int[] nums) {
            long res = 0L;
            int i = 0, n = nums.length;
            while (i < n) {
                int j = i;
                while (j < n && nums[j] == 0) {
                    j++;
                }
                int len = j - i;
                if (len > 0) {
                    res += (long) len * (len + 1) / 2;
                }
                i = ++j;
            }
            return res;
        }
    }
}
