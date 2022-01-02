package p2500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/
 *
 * @author half-dead
 */
public class Puzzle2023 {

    class Solution {
        public int numOfPairs(String[] nums, String target) {
            Map<String, Integer> map = new HashMap<>();
            for (String num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int res = 0;
            for (String key : map.keySet()) {
                int cnt = map.get(key);

                if (target.equals(key + key)) {
                    res += cnt * (cnt - 1);
                } else if (target.startsWith(key)) {
                    String tail = target.substring(key.length());
                    res += cnt * map.getOrDefault(tail, 0);
                }
            }
            return res;
        }
    }
}
