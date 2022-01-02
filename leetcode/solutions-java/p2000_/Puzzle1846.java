package p2000_;

import java.util.Arrays;

/**
 * @author half-dead
 */
public class Puzzle1846 {

    class Solution {
        public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
            Arrays.sort(arr);
            int prev = 1;
            for (int i = 1; i < arr.length; i++) {
                prev = Math.min(arr[i], prev + 1);
            }
            return prev;
        }
    }
}
