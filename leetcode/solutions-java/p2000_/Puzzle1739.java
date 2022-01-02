package p2000_;

/**
 * https://leetcode.com/problems/building-boxes/
 *
 * @author half-dead
 */
public class Puzzle1739 {

    // binary search + simple math, O(sqrt(N) * logN) time
    class Solution {
        public int minimumBoxes(int n) {
            int lo = 1, hi = n;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                long num = cnt(mid, n);

                if (num >= n) hi = mid;
                else lo = mid + 1;
            }
            return lo;
        }

        // count how many boxes we can build with m boxes on the floor
        long cnt(int m, int n) {
            double sqrt = Math.sqrt(m * 2);
            long edge = (long) sqrt;

            // edge is the side length of the maximum perfect 2-d triangle on the floor,
            // we can build a perfect pyramid on top of the triangle on the floor
            while (edge * (edge + 1) > 2L * m) edge--;

            long extra = m - edge * (edge + 1) / 2, total = 0L;

            // forgot about those geometry equations, here we use brute force
            while (edge > 0) {
                total += edge * (edge + 1) / 2;
                edge--;
                if (total >= n) break;
            }

            // with extra boxes on the floor, we could build another
            // perfect 2-d triangle(on top of the surface of our pyramid) with side length=extra
            if (extra > 1) total += extra * (extra - 1) / 2;

            return total + extra;
        }
    }
}
