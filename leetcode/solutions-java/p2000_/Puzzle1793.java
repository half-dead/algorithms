package p2000_;

/**
 * https://leetcode.com/problems/maximum-score-of-a-good-subarray/
 *
 * @author half-dead
 */
public class Puzzle1793 {

    // two-pointers, spread from k, O(N)time, O(1) space
    class Solution {
        public int maximumScore(int[] nums, int k) {
            int lo = k, hi = k, min = nums[k], res = nums[k], n = nums.length;

            while (lo > 0 || hi < n - 1) {
                if (lo == 0) hi++;
                else if (hi == n - 1) lo--;
                else if (nums[lo - 1] >= nums[hi + 1]) lo--;
                else hi++;

                min = Math.min(min, Math.min(nums[lo], nums[hi]));
                res = Math.max(res, min * (hi - lo + 1));
            }
            return res;
        }
    }

    // two pass, two pointers, O(N) time & space
    class Solution0 {
        public int maximumScore(int[] nums, int k) {
            int n = nums.length, res = nums[k];

            int[] min = new int[n];
            min[k] = nums[k];
            for (int i = k - 1; i >= 0; i--) {
                min[i] = Math.min(min[i + 1], nums[i]);
            }
            for (int i = k + 1; i < n; i++) {
                min[i] = Math.min(min[i - 1], nums[i]);
            }

            int lo = 0, hi = n - 1;
            while (lo <= k) {
                while (hi > k && min[lo] > min[hi]) hi--;
                res = Math.max(res, min[lo] * (hi - lo + 1));
                lo++;
            }

            lo = 0;
            hi = n - 1;
            while (hi >= k) {
                while (lo < k && min[lo] < min[hi]) lo++;
                res = Math.max(res, min[hi] * (hi - lo + 1));
                hi--;
            }
            return res;
        }
    }
}
