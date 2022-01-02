package p2000_;

/**
 * https://leetcode.com/problems/add-minimum-number-of-rungs/
 *
 * @author half-dead
 */
public class Puzzle1936 {

    class Solution {
        public int addRungs(int[] rungs, int dist) {
            int prev = 0, res = 0;
            for (int rung : rungs) {
                int diff = rung - prev;
                if (diff > dist) {
                    res += (diff - 1) / dist;
                }
                prev = rung;
            }
            return res;
        }
    }
}
