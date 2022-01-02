package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/moving-stones-until-consecutive-ii/
 *
 * @author half-dead
 */
public class Puzzle1040 {

    class Solution {
        public int[] numMovesStonesII(int[] stones) {

            Arrays.sort(stones);
            int len = stones.length, gap = stones[len - 1] - stones[0] + 1 - len;
            if (gap <= 1) return new int[]{gap, gap};

            int min = Integer.MAX_VALUE, start = 0, end = 0, lo = stones[start], hi, cnt = 0;
            while (end < len) {
                hi = stones[end++];
                cnt++;
                if (hi >= lo + len) {
                    lo = stones[++start];
                    cnt--;
                }
                int space = len - cnt;
                if (space == 1 && lo + len - 1 != hi) space = 2;
                min = Math.min(min, space);
            }

            return new int[]{min, gap - Math.min(stones[1] - stones[0] - 1, stones[len - 1] - stones[len - 2] - 1)};
        }
    }
}
