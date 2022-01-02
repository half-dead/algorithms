package p2000_;

/**
 * https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
 *
 * @author half-dead
 */
public class Puzzle1567 {

    class Solution {
        public int getMaxLen(int[] nums) {
            int res = 0, cp = 0, cn = 0;
            for (int n : nums) {
                int ncp = 0, ncn = 0;
                if (n > 0) {
                    ncp = cp + 1;
                    if (cn > 0) ncn = cn + 1;
                } else if (n < 0) {
                    ncp = cn > 0 ? cn + 1 : 0;
                    ncn = cp > 0 ? cp + 1 : 1;
                }
                cp = ncp;
                cn = ncn;
                res = Math.max(res, cp);
            }
            return res;
        }
    }
}
