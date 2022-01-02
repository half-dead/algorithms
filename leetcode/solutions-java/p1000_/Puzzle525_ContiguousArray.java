package p1000_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contiguous-array/
 *
 * @author half-dead
 */
public class Puzzle525_ContiguousArray {

    class Solution {
        public int findMaxLength(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int count = 0, max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    count++;
                } else {
                    count--;
                }

                if (map.containsKey(count)) {
                    max = Math.max(max, i - map.get(count));
                } else {
                    map.put(count, i);
                }
            }
            return max;
        }
    }
}
