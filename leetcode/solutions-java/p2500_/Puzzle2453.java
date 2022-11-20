package p2500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/destroy-sequential-targets/
 */
public class Puzzle2453 {
    class Solution {
        public int destroyTargets(int[] nums, int space) {
            Map<Integer, int[]> map = new HashMap<>();
            for (int v : nums) {
                int mod = v % space;
                int[] temp = map.computeIfAbsent(mod, x -> new int[]{0, Integer.MAX_VALUE});
                temp[0]++;
                temp[1] = Math.min(temp[1], v);
            }

            int max = 0, res = Integer.MAX_VALUE;
            for (int[] group : map.values()) {
                if (group[0] > max) {
                    max = group[0];
                    res = group[1];
                } else if (group[0] == max && group[1] < res) {
                    res = group[1];
                }
            }
            return res;
        }
    }
}
