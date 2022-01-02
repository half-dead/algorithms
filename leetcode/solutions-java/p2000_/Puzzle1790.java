package p2000_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
 *
 * @author half-dead
 */
public class Puzzle1790 {

    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            if (s1.equals(s2)) return true;

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (list.size() == 2) return false;
                    list.add(i);
                }
            }
            return list.size() == 2 &&
                    s1.charAt(list.get(0)) == s2.charAt(list.get(1)) &&
                    s1.charAt(list.get(1)) == s2.charAt(list.get(0));
        }
    }
}
