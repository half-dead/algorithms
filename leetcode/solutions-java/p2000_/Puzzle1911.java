package p2000_;

/**
 * https://leetcode.com/problems/maximum-alternating-subsequence-sum/
 *
 * @author half-dead
 */
public class Puzzle1911 {

    // greedy
    class Solution {
        public long maxAlternatingSum(int[] nums) {
            int len = nums.length;
            int i = 0;
            long res = 0L;
            while (i < len) {
                while (i < len - 1 && nums[i] <= nums[i + 1]) i++;
                res += nums[i];

                while (i < len - 1 && nums[i] >= nums[i + 1]) i++;

                if (i < len - 1) res -= nums[i];
                else break;
            }
            return res;
        }
    }
}
