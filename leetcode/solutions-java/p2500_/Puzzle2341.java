package p2500_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/maximum-number-of-pairs-in-array/
 *
 * @author half-dead
 */
public class Puzzle2341 {
    class Solution {
        public int[] numberOfPairs(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int[] res = new int[2];
            for (int x : nums) {
                if (set.remove(x)) {
                    res[0]++;
                } else {
                    set.add(x);
                }
            }
            res[1] = set.size();
            return res;
        }
    }
}
