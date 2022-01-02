package p2000_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/tuple-with-same-product/
 *
 * @author half-dead
 */
public class Puzzle1726 {

    class Solution {
        public int tupleSameProduct(int[] nums) {
            int len = nums.length, res = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    int p = nums[i] * nums[j];
                    map.put(p, map.getOrDefault(p, 0) + 1);
                }
            }
            for (int v : map.values()) {
                res += v * (v - 1) * 4;
            }
            return res;
        }
    }
}
