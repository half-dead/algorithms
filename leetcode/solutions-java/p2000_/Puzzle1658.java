package p2000_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 *
 * @author half-dead
 */
public class Puzzle1658 {
    class Solution {
        public int minOperations(int[] nums, int x) {
            int sum = 0, len = nums.length;
            Map<Integer, Integer> map = new HashMap<>(len);
            map.put(0, 0);
            for (int i = 0; i < len; i++) {
                sum += nums[i];
                map.put(sum, i + 1);
                if (sum >= x) break;
            }

            int res = map.getOrDefault(x, len + 1);
            for (int i = len - 1; i >= 0; i--) {
                x -= nums[i];
                Integer t = map.get(x);
                if (t != null) {
                    res = Math.min(res, len - 1 - i + 1 + t);
                }
                if (x <= 0) break;
            }
            if (res > len) res = -1;
            return res;
        }
    }
}
