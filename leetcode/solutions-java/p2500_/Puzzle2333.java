package p2500_;

/**
 * https://leetcode.com/problems/minimum-sum-of-squared-difference/
 *
 * @author half-dead
 */
public class Puzzle2333 {

    // bucket sort, greedy
    class Solution {
        public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
            int[] diffs = new int[100001];
            int n = nums1.length;
            for (int i = 0; i < n; i++) {
                diffs[Math.abs(nums1[i] - nums2[i])]++;
            }

            int j = 100000, k = k1 + k2;
            while (j > 0 && k > 0) {
                if (diffs[j] > 0) {
                    int x = Math.min(diffs[j], k);
                    diffs[j] -= x;
                    diffs[j - 1] += x;
                    k -= x;
                }
                if (k > 0) {
                    j--;
                }
            }

            long res = 0L;
            while (j > 0) {
                if (diffs[j] > 0) {
                    res += (long) j * j * diffs[j];
                }
                j--;
            }
            return res;
        }
    }

}
