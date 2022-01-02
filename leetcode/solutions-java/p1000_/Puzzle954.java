package p1000_;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/array-of-doubled-pairs/
 *
 * @author half-dead
 */
public class Puzzle954 {
    class Solution {
        public boolean canReorderDoubled(int[] a) {
            int zeroCount = 0;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int n : a)
                if (n == 0) zeroCount++;
                else map.put(n, map.getOrDefault(n, 0) + 1);

            if (zeroCount % 2 != 0) return false;

            while (map.size() > 0) {
                Map.Entry<Integer, Integer> entry = map.firstEntry();
                int min = entry.getKey(), count = entry.getValue();

                int pair = 0;
                if (min < 0) {
                    if (min % 2 != 0) return false;
                    pair = min / 2;
                } else pair = min * 2;

                Integer pairCount = map.get(pair);
                if (pairCount == null || count > pairCount) return false;

                map.remove(min);
                pairCount -= count;
                if (pairCount == 0) map.remove(pair);
                else map.put(pair, pairCount);
            }
            return true;
        }
    }
}
