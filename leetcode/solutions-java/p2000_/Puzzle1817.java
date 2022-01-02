package p2000_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/finding-the-users-active-minutes/
 *
 * @author half-dead
 */
public class Puzzle1817 {

    class Solution {
        public int[] findingUsersActiveMinutes(int[][] logs, int k) {
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int[] log : logs) {
                int uid = log[0];
                int minute = log[1];
                map.computeIfAbsent(uid, (a) -> new HashSet<>()).add(minute);
            }

            int[] res = new int[k];
            for (Set<Integer> actions : map.values()) {
                res[actions.size() - 1]++;
            }
            return res;
        }
    }
}
