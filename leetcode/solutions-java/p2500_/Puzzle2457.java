package p2500_;

/**
 * https://leetcode.com/problems/minimum-addition-to-make-integer-beautiful/
 */
public class Puzzle2457 {

    class Solution {
        public long makeIntegerBeautiful(long n, int target) {
            int total = sumDigits(n);
            if (total <= target) return 0L;

            long mod = 10;
            while (mod < n) {
                long x = n % mod;
                if (total - sumDigits(x) + 1 <= target) {
                    return mod - x;
                }
                mod *= 10;
            }
            return mod - n;
        }

        private int sumDigits(long n) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum;
        }
    }
}
