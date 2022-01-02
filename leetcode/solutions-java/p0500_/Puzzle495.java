package p0500_;

/**
 * https://leetcode.com/problems/teemo-attacking/
 *
 * @author half-dead
 */
public class Puzzle495 {

    class Solution {
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            if (timeSeries.length == 0) return 0;
            int res = 0;
            for (int i = 1; i < timeSeries.length; i++) {
                res += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
            }
            return res + duration;
        }
    }
}
