package p2500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/
 *
 * @author half-dead
 */
public class Puzzle2244 {

    class Solution {
        public int minimumRounds(int[] tasks) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int x : tasks) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }

            int res = 0;
            for (int k : map.keySet()) {
                int v = map.get(k);
                if (v == 1) return -1;
                if (v % 3 == 0) res += v / 3;
                else res += v / 3 + 1;
            }
            return res;
        }
    }
}
