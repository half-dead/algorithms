package p2000_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/count-the-number-of-consistent-strings/
 *
 * @author half-dead
 */
public class Puzzle1684 {
    class Solution {
        public int countConsistentStrings(String allowed, String[] words) {
            Set<Character> set = new HashSet<>();
            for (char c : allowed.toCharArray()) set.add(c);

            int res = words.length;
            for (String w : words) {
                for (char c : w.toCharArray()) {
                    if (!set.contains(c)) {
                        res--;
                        break;
                    }
                }
            }
            return res;
        }
    }
}
