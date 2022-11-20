package p2500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/most-frequent-even-element/
 *
 * @author half-dead
 */
public class Puzzle2404 {

    class Solution {
        public int mostFrequentEven(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int res = -1, freq = 0;
            for (int v : nums) {
                if (v % 2 == 0) {
                    int cnt = map.getOrDefault(v, 0) + 1;
                    map.put(v, cnt);
                    if (cnt > freq || (cnt == freq && v < res)) {
                        freq = cnt;
                        res = v;
                    }
                }
            }
            return res;
        }
    }
}
