package p2500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximize-the-topmost-element-after-k-moves/
 *
 * @author half-dead
 */
public class Puzzle2202 {
    class Solution {
        public int maximumTop(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();

            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int v = nums[i];
                map.put(v, Math.min(i, map.getOrDefault(v, n)));
            }

            int res = -1;
            for (int v : map.keySet()) {
                int i = map.get(v);
                if ((k % 2) == (i % 2) && k >= i) {
                    res = Math.max(res, v);
                } else if (k >= i + 3 && n != 1) {
                    res = Math.max(res, v);
                }
            }
            return res;
        }
    }

}
