package p2000_;

/**
 * https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
 *
 * @author half-dead
 */
public class Puzzle1503 {

    class Solution {
        public int getLastMoment(int n, int[] left, int[] right) {
            int res = 0;
            for (int x : left) res = Math.max(res, x);
            for (int x : right) res = Math.max(n - x, res);
            return res;
        }
    }
}
