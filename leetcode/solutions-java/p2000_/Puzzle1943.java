package p2000_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/describe-the-painting/
 *
 * @author half-dead
 */
public class Puzzle1943 {

    class Solution {
        public List<List<Long>> splitPainting(int[][] segments) {
            int max = 0, left = 0;
            for (int[] seg : segments) max = Math.max(max, seg[1]);

            // in the decription, because of '5+7' and '1+11' are different mixed color
            // we have to use a 2-d array to store the start/end of a segment seperately
            // otherwise, 1-d array is enough
            long[][] colors = new long[max + 1][2];
            for (int[] seg : segments) {
                colors[seg[0]][0] += seg[2];
                colors[seg[1]][1] -= seg[2];
            }

            List<List<Long>> res = new ArrayList<>();
            long prevColor = 0, color = 0;
            for (int i = 1; i < colors.length; i++) {
                color += colors[i][0] + colors[i][1];
                if (colors[i][0] != 0 || colors[i][1] != 0) {
                    if (prevColor != 0) {
                        res.add(Arrays.asList((long) left, (long) i, prevColor));
                    }
                    left = i;
                }
                prevColor = color;
            }
            return res;
        }
    }
}
