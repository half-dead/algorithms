package p2000_;

/**
 * https://leetcode.com/problems/count-of-matches-in-tournament
 *
 * @author half-dead
 */
public class Puzzle1688 {
    class Solution {
        public int numberOfMatches(int n) {
            return n - 1;
        }
    }

    class StupidSolution {
        public int numberOfMatches(int n) {
            int res = 0;
            while (n > 1) {
                res += n >> 1;
                n = (n >> 1) + (n % 2);
            }
            return res;
        }
    }
}
