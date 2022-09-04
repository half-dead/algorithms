package p2500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/
 *
 * @author half-dead
 */
public class Puzzle2260 {

    class Solution {
        public int minimumCardPickup(int[] cards) {
            Map<Integer, Integer> map = new HashMap<>();
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < cards.length; i++) {
                int v = cards[i];
                Integer prev = map.put(v, i);
                if (prev != null) {
                    res = Math.min(res, i - prev + 1);
                }
            }
            return res > cards.length ? -1 : res;
        }
    }
}
