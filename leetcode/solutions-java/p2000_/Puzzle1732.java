package p2000_;

/**
 * https://leetcode.com/problems/find-the-highest-altitude/submissions/
 *
 * @author half-dead
 */
public class Puzzle1732 {
    class Solution {
        public int largestAltitude(int[] gain) {
            int res = 0, sum = 0;
            for (int g : gain) res = Math.max(res, sum += g);
            return res;
        }
    }
}
