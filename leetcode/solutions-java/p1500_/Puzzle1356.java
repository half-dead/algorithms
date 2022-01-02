package p1500_;

import java.util.Arrays;

/**
 * @author half-dead
 */
public class Puzzle1356 {
    class Solution {
        public int[] sortByBits(int[] arr) {
            return Arrays.stream(arr).boxed().sorted((a, b) -> {
                if (a - b == 0) return 0;
                int d = Integer.bitCount(a) - Integer.bitCount(b);
                return d == 0 ? a - b : d;
            }).mapToInt(Integer::intValue).toArray();
        }
    }
}
