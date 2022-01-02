package p2000_;

/**
 * https://leetcode.com/problems/minimum-speed-to-arrive-on-time/
 *
 * @author half-dead
 */
public class Puzzle1870 {

    class Solution {
        public int minSpeedOnTime(int[] dist, double hour) {
            int len = dist.length;
            if (len > (int) Math.ceil(hour)) return -1;

            int lo = 1, hi = 10000000;
            while (lo < hi) {
                int mid = (lo + hi) >> 1;
                if (check(dist, mid, hour)) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            return hi;
        }

        boolean check(int[] dist, int s, double h) {
            int spent = 0;
            for (int i = 0; i < dist.length - 1; i++) {
                spent += (dist[i] + s - 1) / s;
                if (spent >= h) return false;
            }
            return spent + ((double) dist[dist.length - 1] / s) <= h;
        }
    }
}
