package p2500_;

/**
 * https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
 */
public class Puzzle2461 {
    class Solution {
        public long maximumSubarraySum(int[] nums, int k) {
            int n = nums.length, distinct = 0;
            int[] freq = new int[100001];
            long sum = 0L, res = 0L;
            for (int i = 0; i < n; i++) {
                if (i >= k) {
                    sum -= nums[i - k];
                    if (freq[nums[i - k]]-- == 1) {
                        distinct--;
                    }
                }

                sum += nums[i];

                if (freq[nums[i]]++ == 0) {
                    distinct++;
                }
                if (distinct == k) {
                    res = Math.max(res, sum);
                }
            }
            return res;
        }
    }
}
