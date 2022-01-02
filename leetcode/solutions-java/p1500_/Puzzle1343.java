package p1500_;

/**
 * https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
 *
 * @author half-dead
 */
public class Puzzle1343 {

    class Solution {
        public int numOfSubarrays(int[] arr, int k, int threshold) {
            int n = arr.length, sum = 0, res = 0, target = k * threshold;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (i >= k) sum -= arr[i - k];
                if (i >= k - 1 && sum >= target) res++;
            }
            return res;
        }
    }
}
