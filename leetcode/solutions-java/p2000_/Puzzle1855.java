package p2000_;

/**
 * https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/
 *
 * @author half-dead
 */
public class Puzzle1855 {

    class Solution {
        public int maxDistance(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            int i = 0, j = 0, res = 0;
            while (i < m && j < n) {
                while (i < m && nums1[i] > nums2[j]) {
                    i++;
                }
                if (i == m) break;
                while (j < n && nums1[i] <= nums2[j]) {
                    j++;
                }
                res = Math.max(res, j - i - 1);
            }
            return res;
        }
    }
}
