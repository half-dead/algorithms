package p1500_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 *
 * @author half-dead
 */
public class Puzzle1282 {
    class Solution {
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < groupSizes.length; i++)
                map.computeIfAbsent(groupSizes[i], k -> new ArrayList<>()).add(i);

            List<List<Integer>> result = new ArrayList<>();
            for (int gs : map.keySet()) {
                List<Integer> ids = map.get(gs);
                if (gs == ids.size()) result.add(ids);
                else for (int from = 0; from < ids.size(); ) result.add(ids.subList(from, from += gs));
            }
            return result;
        }
    }
}
