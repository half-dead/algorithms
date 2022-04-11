package p2500_;

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/
 *
 * @author half-dead
 */
public class Puzzle2224 {

    class Solution {
        public int convertTime(String current, String correct) {
            int start = Integer.parseInt(current.substring(0, 2)) * 60 + Integer.parseInt(current.substring(3, 5));
            int end = Integer.parseInt(correct.substring(0, 2)) * 60 + Integer.parseInt(correct.substring(3, 5));
            int diff = end - start;
            int ans = diff / 60;
            diff %= 60;
            ans += diff / 15;
            diff %= 15;
            ans += diff / 5;
            diff %= 5;
            return ans + diff;
        }
    }
}
