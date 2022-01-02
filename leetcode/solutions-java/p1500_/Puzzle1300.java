package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/
 *
 * @author half-dead
 */
public class Puzzle1300 {


    // sort
    class Solution {
        public int findBestValue(int[] arr, int target) {
            Arrays.sort(arr);

            int n = arr.length, avg = target / n;
            if (arr[n - 1] <= avg) return arr[n - 1];

            int start = 0, rest = n;
            while (start < n && arr[start] < avg) {
                target -= arr[start++];
                if (--rest == 0) break;
                avg = target / (rest);
            }
            if (start == n) return arr[n - 1];
            if (target - avg * rest <= (avg + 1) * rest - target) return avg;
            else return avg + 1;
        }
    }
}
