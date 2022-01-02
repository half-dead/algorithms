package p1500_;

/**
 * https://leetcode.com/problems/k-concatenation-maximum-sum/
 *
 * @author half-dead
 */
public class Puzzle1191 {

    class Solution {
        public int kConcatenationMaxSum(int[] arr, int k) {
            int mod = 1000000007;
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            int sum = 0, temp = 0, maxSum = 0;
            for (int n : arr) {
                sum += n;
                temp += n;
                if (temp < 0) {
                    temp = 0;
                } else {
                    maxSum = Math.max(maxSum, temp);
                }
                min = Math.min(min, n);
                max = Math.max(max, n);
            }
            if (max <= 0) return 0;
            if (min >= 0) return (int) (((long) sum * k) % mod);
            if (k == 1) return maxSum;

            for (int n : arr) {
                temp += n;
                if (temp < 0) {
                    temp = 0;
                } else {
                    maxSum = Math.max(maxSum, temp);
                }
            }
            if (sum > 0) {
                maxSum += (int) (((long) sum * (k - 2)) % mod);
            }
            return maxSum;
        }
    }
}
