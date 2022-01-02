package p1500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/cinema-seat-allocation/
 *
 * @author half-dead
 */
public class Puzzle1386 {

    // optimized solution, 11ms, beats 100% time
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>(reservedSeats.length);
        for (int[] rs : reservedSeats) {
            int c = rs[1];
            if (c == 1 || c == 10) continue;
            int r = rs[0];
            map.put(r, map.getOrDefault(r, 0) | (1 << c));
        }
        int max = n << 1, a2 = 0B100_0000_001_0;
        int b1 = 0B100_0011_111_0, b2 = 0B111_0000_111_0, b3 = 0B111_1100_001_0;
        for (int row : map.values()) {
            if ((row | a2) == a2) continue;
            if ((row | b1) == b1 || (row | b2) == b2 || (row | b3) == b3) max--;
            else max -= 2;
        }
        return max;
    }
}
}
