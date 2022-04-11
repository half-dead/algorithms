package p2500_;

/**
 * https://leetcode.com/problems/minimum-time-to-complete-trips/
 *
 * @author half-dead
 */
public class Puzzle2187 {

    public static void main(String[] args) {
        Solution solution = new Puzzle2187().new Solution();
        long r = solution.minimumTime(new int[]{
                39, 82, 69, 37, 78, 14, 93, 36, 66, 61, 13, 58, 57, 12, 70, 14, 67, 75, 91, 1, 34, 68, 73, 50, 13, 40, 81, 21, 79, 12, 35, 18, 71, 43, 5, 50, 37, 16, 15, 6, 61, 7, 87, 43, 27, 62, 95, 45, 82, 100, 15, 74, 33, 95, 38, 88, 91, 47, 22, 82, 51, 19, 10, 24, 87, 38, 5, 91, 10, 36, 56, 86, 48, 92, 10, 26, 63, 2, 50, 88, 9, 83, 20, 42, 59, 55, 8, 15, 48, 25
        }, 4187);
        System.out.println(r);
    }

    // binary search
    class Solution {
        public long minimumTime(int[] time, int totalTrips) {
            long lo = 0L, hi = Long.MAX_VALUE;
            while (lo < hi) {
                long mid = lo + (hi - lo) / 2;
                long cnt = count(time, mid, totalTrips);
                if (cnt < totalTrips) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }

        long count(int[] time, long mid, int max) {
            long res = 0L;
            for (int t : time) {
                res += mid / t;
                if (res >= max) break;
            }
            return res;
        }
    }
}
