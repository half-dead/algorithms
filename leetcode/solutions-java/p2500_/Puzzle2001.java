package p2500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/
 *
 * @author half-dead
 */
public class Puzzle2001 {

    class Solution {
        public long interchangeableRectangles(int[][] rectangles) {
            Map<Double, Long> map = new HashMap<>();
            for (int[] rect : rectangles) {
                double ratio = rect[0] / (double) rect[1];
                map.put(ratio, map.getOrDefault(ratio, 0L) + 1L);
            }

            long res = 0L;
            for (long cnt : map.values()) {
                res += cnt * (cnt - 1) / 2;
            }
            return res;
        }
    }
}
