package p0500_;

import java.util.Arrays;
import java.util.Random;

/**
 * https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/
 *
 * @author half-dead
 */
public class Puzzle497 {

    class Solution {
        int[][] rects;
        int[] sum;
        int max;
        Random rand;

        public Solution(int[][] args) {
            rects = args;
            sum = new int[rects.length + 1];
            rand = new Random();

            int i = 1;
            for (int[] r : rects) {
                sum[i] = sum[i++ - 1] + (r[2] - r[0] + 1) * (r[3] - r[1] + 1);
            }
            max = sum[--i];
        }

        public int[] pick() {
            int target = rand.nextInt(max) + 1, pos = Arrays.binarySearch(sum, target);
            if (pos < 0) pos = -pos - 1;

            int p = target - 1 - sum[pos - 1];
            int[] r = rects[--pos];
            int x1 = r[0], y1 = r[1], h = r[3] - y1 + 1;
            return new int[]{x1 + p / h, y1 + p % h};
        }
    }

}
