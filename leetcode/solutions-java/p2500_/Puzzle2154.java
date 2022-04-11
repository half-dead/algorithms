package p2500_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/keep-multiplying-found-values-by-two/
 *
 * @author half-dead
 */
public class Puzzle2154 {
    class Solution {
        public int findFinalValue(int[] nums, int original) {
            Set<Integer> set = new HashSet<>();
            for (int x : nums) set.add(x);
            while (set.contains(original)) {
                original <<= 1;
            }
            return original;
        }
    }
}
