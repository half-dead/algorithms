package p2500_;

/**
 * https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/
 *
 * @author half-dead
 */
public class Puzzle2134 {

    class Solution {
        public int minSwaps(int[] nums) {
            int n = nums.length, window = 0;
            for (int v : nums) window += v;

            int lo = 0, hi = 0, res = window, cnt = 0;
            while (lo < n) {
                cnt += nums[hi++ % n];

                if (hi - lo > window) cnt -= nums[lo++];

                res = Math.min(res, window - cnt);
            }
            return res;
        }
    }
}
