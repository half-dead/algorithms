package p2500_;

/**
 * https://leetcode.com/problems/minimum-bit-flips-to-convert-number/submissions/
 *
 * @author half-dead
 */
public class Puzzle2220 {

    class Solution {
        public int minBitFlips(int start, int goal) {
            return Integer.bitCount(start ^ goal);
        }
    }
}
