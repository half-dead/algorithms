package p2500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/most-frequent-number-following-key-in-an-array/
 *
 * @author half-dead
 */
public class Puzzle2190 {
    class Solution {
        public int mostFrequent(int[] nums, int key) {
            int res = 0, max = 0, n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i < n; i++) {
                if (nums[i - 1] == key) {
                    int v = nums[i];
                    map.put(v, map.getOrDefault(v, 0) + 1);
                }
            }
            for (int k : map.keySet()) {
                int v = map.get(k);
                if (v > max) {
                    max = v;
                    res = k;
                }
            }
            return res;
        }
    }
}
