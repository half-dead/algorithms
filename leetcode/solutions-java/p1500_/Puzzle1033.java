package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/moving-stones-until-consecutive/
 *
 * @author half-dead
 */
public class Puzzle1033 {

    class Solution {
        public int[] numMovesStones(int a, int b, int c) {
            int[] m = new int[]{a, b, c};
            Arrays.sort(m);
            if (m[2] - m[0] == 2) return new int[]{0, 0};
            return new int[]{Math.min(m[1] - m[0], m[2] - m[1]) < 3 ? 1 : 2, m[2] - m[0] - 2};
        }
    }
}
