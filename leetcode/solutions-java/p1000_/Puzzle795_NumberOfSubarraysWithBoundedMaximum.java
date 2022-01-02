package p1000_;

/**
 * https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
 *
 * @author half-dead
 */
public class Puzzle795_NumberOfSubarraysWithBoundedMaximum {
    class Solution {
        public int numSubarrayBoundedMax(int[] arr, int left, int right) {
            int result = 0, count = 0, prev = 0;
            for (int i = 0; i < arr.length; i++) {
                int curr = 0;
                if (arr[i] < left) {
                    count++;
                    curr = prev;
                } else if (arr[i] > right) {
                    count = 0;
                } else {
                    curr = ++count;
                }
                result += (prev = curr);
            }
            return result;
        }
    }
}
