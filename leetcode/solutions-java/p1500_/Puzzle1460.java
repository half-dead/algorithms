package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 *
 * @author half-dead
 */
public class Puzzle1460 {
    class Solution {
        public boolean canBeEqual(int[] target, int[] arr) {
            Arrays.sort(target);
            Arrays.sort(arr);
            return Arrays.equals(target, arr);
        }
    }
}
