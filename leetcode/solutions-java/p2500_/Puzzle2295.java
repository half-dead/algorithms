package p2500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/replace-elements-in-an-array/
 *
 * @author half-dead
 */
public class Puzzle2295 {

    class Solution {
        public int[] arrayChange(int[] nums, int[][] operations) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] op : operations) {
                int x = op[0], y = op[1];
                int original = map.getOrDefault(x, x);
                if (original != x) {
                    map.remove(x);
                }
                map.put(y, original);
            }

            Map<Integer, Integer> rmap = new HashMap<>();
            for (int k : map.keySet()) {
                int v = map.get(k);
                rmap.put(v, k);
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = rmap.getOrDefault(nums[i], nums[i]);
            }
            return nums;
        }
    }
}
