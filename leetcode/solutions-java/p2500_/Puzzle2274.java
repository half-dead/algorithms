package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/
 *
 * @author half-dead
 */
public class Puzzle2274 {

    class Solution {
        public int maxConsecutive(int bottom, int top, int[] special) {
            Arrays.sort(special);

            int prev = bottom;
            int i = 0, n = special.length, res = 0;
            while (i < n) {
                int v = special[i++];
                res = Math.max(res, v - prev);
                prev = v + 1;
            }
            res = Math.max(res, top - prev + 1);
            return res;
        }
    }
}
