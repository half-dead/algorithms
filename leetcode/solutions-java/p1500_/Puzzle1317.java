package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
 *
 * @author half-dead
 */
public class Puzzle1317 {

    public static void main(String[] args) {
        Solution s = new Puzzle1317().new Solution();
        System.out.println(Arrays.toString(s.getNoZeroIntegers(1010101010)));
    }

    class Solution {
        public int[] getNoZeroIntegers(int n) {
            int a = 0, b = 0, d = 1;
            while (n > 0) {
                int m = n % 10, x, y;
                if (m > 1) {
                    x = 1;
                    y = m - 1;
                } else if (n == m) {
                    x = 0;
                    y = m;
                } else {
                    x = 5;
                    y = 5 + m;
                    n -= 10;
                }
                a += d * x;
                b += d * y;
                d *= 10;
                n /= 10;
            }
            return new int[]{a, b};
        }
    }
}
