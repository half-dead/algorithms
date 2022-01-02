package p1000_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 *
 * @author half-dead
 */
public class Puzzle953_VerifyingAnAlienDictionary {
    class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < order.length(); i++) map.put(order.charAt(i), i);

            for (int i = 1; i < words.length; i++) {
                String w1 = words[i - 1], w2 = words[i];
                int m = 0, n = 0;
                boolean eq = true;
                while (m < w1.length() && n < w2.length()) {
                    int compare = map.get(w1.charAt(m++)).compareTo(map.get(w2.charAt(n++)));
                    if (compare > 0) return false;
                    else if (compare < 0) {
                        eq = false;
                        break;
                    }
                }
                if (eq && w1.length() > w2.length()) return false;
            }
            return true;
        }
    }
}
