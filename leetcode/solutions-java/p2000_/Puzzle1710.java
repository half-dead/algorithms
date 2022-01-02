package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-units-on-a-truck/
 *
 * @author half-dead
 */
public class Puzzle1710 {
    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            Arrays.sort(boxTypes, (a, b) -> {
                return b[1] - a[1];
            });

            int r = 0;
            for (int[] boxType : boxTypes) {
                r += Math.min(boxType[0], truckSize) * boxType[1];
                truckSize -= boxType[0];
                if (truckSize <= 0) {
                    break;
                }
            }
            return r;
        }
    }
}
