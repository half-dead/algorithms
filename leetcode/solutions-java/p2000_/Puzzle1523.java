package p2000_;

/**
 * https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
 *
 * @author half-dead
 */
public class Puzzle1523 {

    class Solution {
        public int countOdds(int low, int high) {
            return (high + 1) / 2 - low / 2;
        }
    }
}
