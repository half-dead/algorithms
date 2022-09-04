package p2500_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
 *
 * @author half-dead
 */
public class Puzzle2357 {

    class Solution {
        public int minimumOperations(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int x : nums) {
                if (x != 0) {
                    set.add(x);
                }
            }
            return set.size();
        }
    }
}
