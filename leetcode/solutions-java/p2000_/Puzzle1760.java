package p2000_;

/**
 * https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/
 *
 * @author half-dead
 */
public class Puzzle1760 {

    // binary search
    class Solution {
        public int minimumSize(int[] nums, int ops) {
            int lo = 1, hi = 1000000000;
            while (lo < hi) {
                int mid = (lo + hi) >> 1;
                if (check(nums, mid, ops)) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            return hi;
        }

        boolean check(int[] nums, int p, int ops) {
            int cnt = 0;
            for (int n : nums) {
                cnt += (n - 1) / p;
                if (cnt > ops) return false;
            }
            return true;
        }
    }
}
