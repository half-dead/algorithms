package p2500_;

/**
 * https://leetcode.com/problems/a-number-after-a-double-reversal/
 *
 * @author half-dead
 */
public class Puzzle2119 {

    class Solution {
        public boolean isSameAfterReversals(int num) {
            return num == 0 || num % 10 != 0;
        }
    }
}
