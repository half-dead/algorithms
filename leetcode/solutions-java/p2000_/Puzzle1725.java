package p2000_;

/**
 * https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/
 *
 * @author half-dead
 */
public class Puzzle1725 {

    class Solution {
        public int countGoodRectangles(int[][] rectangles) {
            int cnt = 0, max = 0;
            for (int[] rect : rectangles) {
                int len = Math.min(rect[0], rect[1]);
                if (len > max) {
                    max = len;
                    cnt = 1;
                } else if (len == max) {
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
