package p2000_;

/**
 * @author half-dead
 */
public class Puzzle1701 {

    class Solution {
        public double averageWaitingTime(int[][] customers) {
            long tot = 0L;

            int time = 0;
            for (int[] c : customers) {
                tot += c[0] < time ? (time - c[0]) : 0;
                tot += c[1];
                time = Math.max(c[0], time) + c[1];
            }

            return tot / (double) customers.length;

        }
    }
}
