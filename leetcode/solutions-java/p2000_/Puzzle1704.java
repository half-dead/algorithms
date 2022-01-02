package p2000_;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/determine-if-string-halves-are-alike/
 *
 * @author half-dead
 */
public class Puzzle1704 {

    class Solution {
        public boolean halvesAreAlike(String s) {
            int[] vowels = new int[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
            Set<Integer> set = Arrays.stream(vowels).boxed().collect(Collectors.toSet());
            int n = s.length(), half = n >> 1, left = 0, right = 0;
            for (int i = 0; i < n; i++) {
                if (set.contains((int) s.charAt(i))) {
                    if (i < half) left++;
                    else right++;
                }
            }
            return left == right;
        }
    }
}
