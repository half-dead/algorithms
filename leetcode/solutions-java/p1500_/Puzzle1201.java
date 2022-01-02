package p1500_;

/**
 * https://leetcode.com/problems/ugly-number-iii/
 *
 * @author half-dead
 */
public class Puzzle1201 {
    public static void main(String[] args) {
        Solution s = new Puzzle1201().new Solution();
        System.out.println(s.nthUglyNumber(5, 2, 3, 3));
    }


    class Solution {
        public int nthUglyNumber(int n, int a, int b, int c) {
            long lo = 1, hi = 2000000000, mid = 0;
            long ab = lcm(a, b), ac = lcm(a, c), bc = lcm(b, c), abc = lcm(lcm(a, b), c);
            while (lo <= hi) {
                mid = (lo + hi) >> 1;
                long cnt = mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc;
                if (cnt == n) {
                    break;
                } else if (cnt > n) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            return (int) (mid - Math.min(Math.min(mid % a, mid % b), mid % c));
        }

        private long gcd(long a, long b) {
            if (a % b == 0) return b;
            return gcd(b, a % b);
        }

        private long lcm(long a, long b) {
            return a * b / gcd(a, b);
        }
    }
}
