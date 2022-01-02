package p1500_;

/**
 * https://leetcode.com/problems/airplane-seat-assignment-probability/
 *
 * @author half-dead
 */
public class Puzzle1227 {

    class Solution {
        public double nthPersonGetsNthSeat(int n) {
            return n == 1 ? 1 : 0.5;
        }
    }
}
