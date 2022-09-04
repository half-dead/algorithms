package p2500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-arithmetic-triplets/
 *
 * @author half-dead
 */
public class Puzzle2367 {

    class Solution {
        public int arithmeticTriplets(int[] nums, int diff) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int v : nums) {
                int prev = v - diff;
                if (map.containsKey(prev)) {
                    int len = map.get(prev);
                    map.remove(prev);
                    map.put(v, len + 1);
                } else {
                    map.put(v, 1);
                }
            }
            int res = 0;
            for (int v : map.values()) {
                if (v > 2) {
                    res += v - 2;
                }
            }
            return res;
        }
    }
}
