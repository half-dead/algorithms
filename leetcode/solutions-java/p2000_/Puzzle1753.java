package p2000_;

/**
 * https://leetcode.com/problems/maximum-score-from-removing-stones/
 *
 * @author half-dead
 */
public class Puzzle1753 {

    class Solution {
        public int maximumScore(int a, int b, int c) {
            int sum = a + b + c, max = Math.max(a, Math.max(b, c)), p = sum - max;
            return p >= max ? sum >> 1 : p;
        }
    }
}
