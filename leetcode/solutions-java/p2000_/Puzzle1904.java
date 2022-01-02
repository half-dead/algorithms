package p2000_;

/**
 * https://leetcode.com/problems/the-number-of-full-rounds-you-have-played/
 *
 * @author half-dead
 */
public class Puzzle1904 {

    class Solution {
        public int numberOfRounds(String startTime, String finishTime) {
            int start = Integer.parseInt(startTime.substring(0, 2)) * 60 + Integer.parseInt(startTime.substring(3));
            int end = Integer.parseInt(finishTime.substring(0, 2)) * 60 + Integer.parseInt(finishTime.substring(3));
            if (start > end) end += 24 * 60;
            if (start % 15 != 0) start = start + 15 - (start % 15);
            if (end % 15 != 0) end = end - (end % 15);
            return Math.max(0, (end - start) / 15);
        }
    }
}
