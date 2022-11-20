package p2500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-number-of-bad-pairs/description/
 */
public class Puzzle2364 {
    class Solution {
        public long countBadPairs(int[] nums) {
            int n = nums.length;
            long total = (long) n * (n - 1) / 2;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                nums[i] -= i;
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            for (int x : map.values()) {
                if (x > 1) {
                    long temp = (long) x * (x - 1) / 2;
                    total -= temp;
                }
            }
            return total;
        }
    }
}
