package p2500_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/
 *
 * @author half-dead
 */
public class Puzzle2150 {

    class Solution {
        public List<Integer> findLonely(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int x : nums) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            List<Integer> res = new ArrayList<>();
            for (int x : map.keySet()) {
                if (map.get(x) == 1 && !map.containsKey(x - 1) && !map.containsKey(x + 1)) {
                    res.add(x);
                }
            }
            return res;
        }
    }
}
