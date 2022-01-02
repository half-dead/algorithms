package p1000_;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Minimum Index Sum of Two Lists
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 *
 * @author half-dead
 */
public class Puzzle599 {
    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < list1.length; i++) map.put(list1[i], i);

            int sum = Integer.MAX_VALUE;
            List<String> result = new LinkedList<>();
            for (int i = 0; i < list2.length; i++) {
                Integer j = map.get(list2[i]);
                int cur = 0;
                if (j != null && (cur = j + i) <= sum) {
                    if (cur < sum) {
                        sum = cur;
                        result.clear();
                    }
                    result.add(list2[i]);
                }
            }
            return result.toArray(new String[0]);
        }
    }
}
