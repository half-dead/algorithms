package p1000_;

/**
 * https://leetcode.com/problems/prime-palindrome/
 *
 * @author half-dead
 */
public class Puzzle866 {

    public static void main(String[] args) {
        Solution s = new Puzzle866().new Solution();
        System.out.println(s.primePalindrome(930));
    }

    // use generation instead of increament to speed up the process
    class Solution {
        public int primePalindrome(int n) {
            String s = n + "", nines = "99999";
            boolean odd = s.length() % 2 != 0;

            String leftPart = s.substring(0, (s.length() + 1) / 2);
            int left = Integer.parseInt(leftPart), max = Integer.parseInt(nines.substring(0, leftPart.length()));
            while (true) {
                int next = gen(left, odd);
                if (next >= n && isPrime(next)) return next;

                if (++left > max) {
                    if (odd) {
                        left /= 10;
                        // no need to change max
                    } else {
                        max = max * 10 + 9;
                    }
                    odd = !odd;
                }
            }
        }

        int gen(int m, boolean odd) {
            int r = m;
            if (odd) m /= 10;
            while (m > 0) {
                r = r * 10 + m % 10;
                m /= 10;
            }
            return r;
        }

        boolean isPrime(int x) {
            int sqrt = (int) Math.sqrt(x);
            for (int i = 2; i <= sqrt; i++)
                if (x % i == 0)
                    return false;
            return x > 1;
        }
    }
}
