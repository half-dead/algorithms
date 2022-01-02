package p1000_;

import java.util.*;

/**
 * https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
 *
 * @author half-dead
 */
public class Puzzle914_XOfAKindInADeckOfCards {

    class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : deck) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }
            Set<Integer> set = new HashSet<>();
            for (Integer i : map.values()) {
                if (i == 1) {
                    return false;
                }
                set.add(i);
            }
            int[] factors = new int[set.size()];
            int i = 0;
            for (Integer n : set) {
                factors[i++] = n;
            }
            Arrays.sort(factors);
            for (int n = 2; n <= factors[0]; n++) {
                boolean flag = true;
                for (int j = 1; j < factors.length; j++) {
                    if (factors[j] % n != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
            return false;
        }
    }
}
