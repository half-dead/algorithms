package p1000_;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/reordered-power-of-2/
 *
 * @author half-dead
 */
public class Puzzle869_ReorderedPowerOf2 {

    class Solution {
        private Set<String> set;

        public Solution() {
            set = new HashSet<>(32);
            int shift = 0;
            while (shift < 32) {
                int n = 1 << shift;
                char[] chars = Integer.toString(n).toCharArray();
                Arrays.sort(chars);
                set.add(new String(chars));
                shift++;
            }
        }

        public boolean reorderedPowerOf2(int n) {
            char[] chars = Integer.toString(n).toCharArray();
            Arrays.sort(chars);
            return set.contains(new String(chars));
        }
    }
}
