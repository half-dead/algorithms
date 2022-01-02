package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reduce-array-size-to-the-half/
 *
 * @author half-dead
 */
public class Puzzle1338_ReduceArraySizeToTheHalf {

    class Solution {
        public int minSetSize(int[] arr) {
            int max = 100001, len = arr.length, half = len >> 1, r = 0, sum = 0;

            int[] count = new int[max];
            for (int n : arr) count[n]++;

            int nonzero = 0;
            for (int n : count) if (n > 0) nonzero++;

            if (nonzero < len) {
                int[] copy = new int[nonzero];
                for (int n : count) if (n > 0) copy[--nonzero] = n;
                count = copy;
            }

            Arrays.sort(count);
            for (int i = count.length - 1; i >= 0; i--) if ((++r) > 0 && (sum += count[i]) >= half) break;
            return r;
        }
    }
}
