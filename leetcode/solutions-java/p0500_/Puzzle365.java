package p0500_;

/**
 * https://leetcode.com/problems/water-and-jug-problem/
 *
 * @author half-dead
 */
public class Puzzle365 {
    class Solution {
        public boolean canMeasureWater(int x, int y, int z) {
            if (z > x + y) return false;
            if (z == x || z == y || z == x + y) return true;
            return z % gcd(x, y) == 0;
        }

        int gcd(int x, int y) {
            return x > 0 ? gcd(y % x, x) : y;
        }
    }
}
