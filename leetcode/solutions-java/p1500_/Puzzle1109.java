package p1500_;

/**
 * https://leetcode.com/problems/corporate-flight-bookings/
 *
 * @author half-dead
 */
public class Puzzle1109 {

    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] sum = new int[n];
            for (int[] b : bookings) {
                sum[b[0] - 1] += b[2];
                if (b[1] < n)
                    sum[b[1]] -= b[2];
            }
            for (int i = 1; i < n; i++) {
                sum[i] += sum[i - 1];
            }
            return sum;
        }
    }
}
