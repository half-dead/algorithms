package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/frequency-of-the-most-frequent-element/
 *
 * @author half-dead
 */
public class Puzzle1838 {

    // sort, sliding-window
    class Solution {
        public int maxFrequency(int[] nums, int k) {
            Arrays.sort(nums);
            long sum = 0L;
            int res = 0;
            for (int len = nums.length, j = 0, i = 0; j < len; j++) {
                sum += nums[j];
                while ((long) nums[j] * (j - i + 1) > sum + k) {
                    sum -= nums[i++];
                }
                res = Math.max(res, j - i + 1);
            }
            return res;
        }
    }

    // sort, prefix-sum, sliding-window
    class Solution1 {
        public int maxFrequency(int[] nums, int k) {
            int len = nums.length, res = 1;

            Arrays.sort(nums);
            long[] psum = new long[len];
            psum[0] = nums[0];
            for (int i = 1; i < len; i++) psum[i] = psum[i - 1] + nums[i];

            int start = 0, end = 0;
            while (++end < len) {
                long d = (long) nums[end] * (end - start + 1) - psum[end] + (start > 0 ? psum[start - 1] : 0);
                if (d <= k) {
                    res = Math.max(res, end - start + 1);
                } else {
                    start++;
                }
            }
            return res;
        }
    }

    // sort, prefix-sum, binary search
    class Solution2 {
        public int maxFrequency(int[] nums, int k) {
            int len = nums.length, res = 1;

            Arrays.sort(nums);
            long[] psum = new long[len];
            psum[0] = nums[0];
            for (int i = 1; i < len; i++) psum[i] = psum[i - 1] + nums[i];

            for (int i = len - 1; i >= 0; i--) {
                if ((long) nums[i] * (i + 1) <= psum[i] + k) {
                    res = Math.max(res, i + 1);
                } else {
                    int lo = 0, hi = i - res;
                    boolean found = false;
                    while (lo < hi) {
                        int mid = (lo + hi) / 2;
                        if ((long) nums[i] * (i - mid + 1) > psum[i] + k - (mid > 0 ? psum[mid - 1] : 0)) {
                            lo = mid + 1;
                        } else {
                            found = true;
                            hi = mid;
                        }
                    }
                    if (found || (long) nums[i] * (i - lo + 1) <= psum[i] + k - (lo > 0 ? psum[lo - 1] : 0))
                        res = Math.max(res, i - lo + 1);
                }
                if (res >= i - 1) break;
            }
            return res;
        }
    }
}
