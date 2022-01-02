package p2000_;

/**
 * https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
 *
 * @author half-dead
 */
public class Puzzle1749 {

    class Solution {
        public int maxAbsoluteSum(int[] nums) {
            int pos = 0, neg = 0, res = 0;
            for (int n : nums) {
                if (n >= 0) {
                    pos = Math.max(n, pos + n);
                    neg = Math.min(0, neg + n);
                } else {
                    pos = Math.max(0, pos + n);
                    neg = Math.min(n, neg + n);
                }
                res = Math.max(res, Math.max(pos, -neg));
            }
            return res;
        }
    }
}
