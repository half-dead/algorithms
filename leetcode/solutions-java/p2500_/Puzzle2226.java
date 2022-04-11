package p2500_;

/**
 * https://leetcode.com/problems/maximum-candies-allocated-to-k-children/
 *
 * @author half-dead
 */
public class Puzzle2226 {

    // binary search
    class Solution {
        public int maximumCandies(int[] candies, long k) {
            long sum = 0L;
            int lo = 1, hi = 0;
            for (int x : candies) {
                sum += x;
                hi = Math.max(hi, x);
            }

            if (sum < k) return 0;
            if (sum == k) return 1;

            while (lo < hi) {
                int mid = (lo + hi + 1) / 2;
                if (check(candies, k, mid)) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            return lo;
        }

        boolean check(int[] candies, long k, int target) {
            for (int x : candies) {
                k -= x / target;
                if (k <= 0) break;
            }
            return k <= 0;
        }
    }
}
