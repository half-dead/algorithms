package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/destroying-asteroids/
 *
 * @author half-dead
 */
public class Puzzle2126 {
    class Solution {
        public boolean asteroidsDestroyed(int mass, int[] asteroids) {
            Arrays.sort(asteroids);
            long p = mass;
            for (int v : asteroids) {
                if (p >= v) {
                    p += v;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
