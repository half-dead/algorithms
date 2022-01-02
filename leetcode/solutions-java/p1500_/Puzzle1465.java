package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
 *
 * @author half-dead
 */
public class Puzzle1465 {

    class Solution {
        public int maxArea(int h, int w, int[] hcuts, int[] vcuts) {
            Arrays.sort(hcuts);
            Arrays.sort(vcuts);
            return (int) ((long) getMax(h, hcuts) * getMax(w, vcuts) % 1000000007L);
        }

        private int getMax(int n, int[] cuts) {
            int len = cuts.length;
            if (len == 0) return n;

            int max = Math.max(cuts[0], n - cuts[len - 1]);
            for (int i = 1; i < len; i++) max = Math.max(max, cuts[i] - cuts[i - 1]);
            return max;
        }
    }
}
