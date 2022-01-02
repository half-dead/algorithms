package p1000_;

/**
 * https://leetcode.com/problems/rectangle-overlap/
 *
 * @author half-dead
 */
public class Puzzle836 {
    class Solution {
        public boolean isRectangleOverlap(int[] a, int[] b) {
            return a[2] > b[0] && a[3] > b[1] && b[2] > a[0] && b[3] > a[1];
        }
    }
}
