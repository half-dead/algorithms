package p2500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/kth-distinct-string-in-an-array/
 *
 * @author half-dead
 */
public class Puzzle2053 {

    class Solution {
        public String kthDistinct(String[] arr, int k) {
            Map<String, Integer> map = new HashMap<>();

            for (String s : arr) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }

            for (String s : arr) {
                if (map.get(s) == 1 && --k == 0)
                    return s;
            }

            return "";
        }
    }
}
