package p2500_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/first-letter-to-appear-twice/
 *
 * @author half-dead
 */
public class Puzzle2351 {
    class Solution {
        public char repeatedCharacter(String s) {
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                if (set.remove(c)) {
                    return c;
                }
                set.add(c);
            }
            return ' ';
        }
    }
}
