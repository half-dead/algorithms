package p0500_;

/**
 * https://leetcode.com/problems/rotate-function/
 *
 * @author half-dead
 */
public class Puzzle396 {
    class Solution {
        public int maxRotateFunction(int[] a) {
            int len = a.length, sum = 0, temp = 0;
            for (int i = 0; i < len; i++) {
                sum += a[i];
                temp += i * a[i];
            }

            int max = temp, pos = len;
            while (--pos > 0) {
                temp = temp + sum - (a[pos] * len);
                max = Math.max(temp, max);
            }
            return max;
        }
    }
}
