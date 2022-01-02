package p2500_;

/**
 * https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/
 *
 * @author half-dead
 */
public class Puzzle2064 {

    // binary search
    class Solution {
        public int minimizedMaximum(int n, int[] quantities) {
            int lo = 1, hi = 1;
            for (int q : quantities) hi = Math.max(hi, q);

            while (lo < hi) {
                int mid = (lo + hi) / 2, cnt = count(mid, quantities);
                if (cnt <= n) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            return lo;
        }

        private int count(int x, int[] qs) {
            int cnt = 0;
            for (int q : qs) {
                cnt += (q + x - 1) / x;
            }
            return cnt;
        }
    }
}
