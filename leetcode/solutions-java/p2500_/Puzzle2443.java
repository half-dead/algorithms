package p2500_;

/**
 * https://leetcode.com/problems/sum-of-number-and-its-reverse/
 */
public class Puzzle2443 {
    class Solution {
        public boolean sumOfNumberAndReverse(int num) {
            for (int i = num / 2; i <= num; i++) {
                if (i + reverse(i) == num) return true;
            }
            return false;
        }

        private int reverse(int n) {
            int rev = 0;
            while (n > 0) {
                rev = rev * 10 + n % 10;
                n /= 10;
            }
            return rev;
        }
    }
}
