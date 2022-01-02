package p2000_;

/**
 * https://leetcode.com/problems/find-the-winner-of-the-circular-game/
 *
 * @author half-dead
 */
public class Puzzle1823 {

    // Josephus problem
    // https://en.wikipedia.org/wiki/Josephus_problem
    class Solution {
        public int findTheWinner(int n, int k) {
            if (k == 1) return n;
            int i = 0, m = 2;
            while (m <= n) {
                i = (i + k) % m;
                m++;
            }
            return i + 1;
        }
    }
}
