package p2000_;

/**https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
 * @author half-dead
 */
public class Puzzle1588 {


    // O(N^2)
    class Solution {
        public int sumOddLengthSubarrays(int[] arr) {
            int n = arr.length, res = 0;
            int[] ps = new int[n + 1];
            for (int i = 0; i < n; i++) ps[i + 1] = ps[i] + arr[i];

            for (int i = 1; i <= n; i += 2) {
                for (int j = i; j <= n; j++) {
                    res += ps[j] - ps[j - i];
                }
            }
            return res;
        }
    }
}
