package p1000_;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/hand-of-straights/
 *
 * @author half-dead
 */
public class Puzzle846_HandOfStraights {

    class Solution {
        public boolean isNStraightHand(int[] cards, int g) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int card : cards) map.put(card, map.getOrDefault(card, 0) + 1);

            while (map.size() > 0) {
                int first = map.firstKey(), cnt = map.remove(first);
                for (int card = first + 1; card < first + g; card++) {
                    Integer next = map.get(card);
                    if (next == null || next < cnt) return false;
                    if (next == cnt) map.remove(card);
                    else map.replace(card, next - cnt);
                }
            }
            return true;
        }

    }
}
