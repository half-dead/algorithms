package p2500_;

import java.util.*;

/**
 * https://leetcode.com/problems/range-frequency-queries/
 *
 * @author half-dead
 */
public class Puzzle2080 {

    class RangeFreqQuery {

        Map<Integer, List<Integer>> map = new HashMap<>(10000);

        public RangeFreqQuery(int[] arr) {
            for (int i = 0, n = arr.length; i < n; i++) {
                int v = arr[i];
                map.computeIfAbsent(v, x -> new ArrayList<>()).add(i);
            }
        }

        public int query(int left, int right, int value) {
            List<Integer> slot = map.get(value);
            if (slot == null) return 0;

            int p1 = Collections.binarySearch(slot, left);
            int p2 = Collections.binarySearch(slot, right);
            if (p1 < 0) p1 = -p1 - 1;
            if (p2 < 0) p2 = -p2 - 2;
            return p2 - p1 + 1;
        }
    }
}
