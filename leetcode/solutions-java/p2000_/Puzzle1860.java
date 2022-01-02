package p2000_;

/**
 * https://leetcode.com/problems/incremental-memory-leak/
 *
 * @author half-dead
 */
public class Puzzle1860 {

    class Solution {
        public int[] memLeak(int m1, int m2) {
            int t = 1;
            while (m1 >= t || m2 >= t) {
                if (m1 >= m2) m1 -= t;
                else m2 -= t;
                t++;
            }
            return new int[]{t, m1, m2};
        }
    }
}
