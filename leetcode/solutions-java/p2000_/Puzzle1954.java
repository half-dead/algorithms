package p2000_;

/**
 * https://leetcode.com/problems/minimum-garden-perimeter-to-collect-enough-apples/
 *
 * @author half-dead
 */
public class Puzzle1954 {

    // can be improved to O(logN) by binary search
    // the equation is 2(2x^3 + 3x^2 + x) = needed
    // given needed <= 10^15, we can set the upper bound to 10^5
    class Solution {
        public long minimumPerimeter(long neededApples) {
            long x = 0L, cnt = 0L;
            while (cnt < neededApples) {
                x++;
                cnt = (x * 2 + 1) * 2 * x * (x + 1);
            }
            return x * 8;
        }
    }
}
