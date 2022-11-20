package p2500_;

/**
 * https://leetcode.com/problems/smallest-even-multiple/
 *
 * @author half-dead
 */
public class Puzzle2413 {
    class Solution {
        public int smallestEvenMultiple(int n) {
            return n % 2 == 0 ? n : (n << 1);
        }
    }
}
