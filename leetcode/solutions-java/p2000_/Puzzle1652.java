package p2000_;

/**
 * https://leetcode.com/problems/defuse-the-bomb/
 *
 * @author half-dead
 */
public class Puzzle1652 {

    // sliding window
    class Solution {
        public int[] decrypt(int[] code, int k) {
            int n = code.length, left, right, sum = 0;

            int[] res = new int[n];
            if (k == 0) return res;

            if (k > 0) {
                left = 1;
                right = left + k - 1;
            } else {
                right = n - 1;
                left = right - (-k) + 1;
            }

            // calculate sum for sliding window
            for (int i = left; i <= right; i++) {
                sum += code[i];
            }

            for (int i = 0; i < n; i++) {
                res[i] = sum;
                sum -= code[left++];
                left %= n;
                right = (right + 1) % n;
                sum += code[right];
            }
            return res;
        }
    }
}
