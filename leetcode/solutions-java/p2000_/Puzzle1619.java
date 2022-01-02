package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/mean-of-array-after-removing-some-elements/
 *
 * @author half-dead
 */
public class Puzzle1619 {

    class Solution {
        public double trimMean(int[] arr) {
            int n = arr.length, sum = 0;
            Arrays.sort(arr);
            for (int i = n / 20; i < n - n / 20; i++) {
                sum += arr[i];
            }
            return sum / (double) (n - n / 10);
        }
    }
}
