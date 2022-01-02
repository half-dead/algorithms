package p1500_;

/**
 * https://leetcode.com/problems/n-th-tribonacci-number/
 *
 * @author half-dead
 */
public class Puzzle1137 {
    class Solution {
        public int tribonacci(int n) {
            if (n < 2) return n;
            int a = 0, b = 1, c = 1, d;
            while (n-- > 2) {
                d = a + b + c;
                a = b;
                b = c;
                c = d;
            }
            return c;
        }
    }

}
