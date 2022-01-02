package p1000_;

/**
 * https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
 *
 * @author half-dead
 */
public class Puzzle668 {

    // binary search, O(min(m,n) * log(mn)) time
    class Solution {
        public int findKthNumber(int m, int n, int k) {
            // make sure m <= n
            if (m > n) return findKthNumber(n, m, k);

            int lo = 1, hi = m * n;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (enough(m, n, mid, k)) hi = mid;
                else lo = mid + 1;
            }
            return lo;
        }

        private boolean enough(int m, int n, int x, int k) {
            int res = x / n * n;
            for (int i = x / n + 1; i <= m; i++) {
                res += Math.min(n, x / i);
                if (res >= k) return true;
            }
            return false;
        }
    }
}
