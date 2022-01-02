package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
 *
 * @author half-dead
 */
public class Puzzle1502 {

    // sort
    // another solution: O(N)time, O(N)space
    // is find max and min, then calculate diff, then check if every number exist in the array
    class Solution {
        public boolean canMakeArithmeticProgression(int[] arr) {
            Arrays.sort(arr);
            int d = arr[1] - arr[0];
            for (int i = 2; i < arr.length; i++) if (arr[i] - arr[i - 1] != d) return false;
            return true;
        }
    }

}
