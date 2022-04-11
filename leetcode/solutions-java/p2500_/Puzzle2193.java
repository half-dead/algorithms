package p2500_;

/**
 * https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/
 *
 * @author half-dead
 */
public class Puzzle2193 {

    class Solution {

        public int minMovesToMakePalindrome(String s) {
            int n = s.length();
            if (n <= 2) return 0;

            char a = s.charAt(0), b = s.charAt(n - 1);
            if (a == b) return minMovesToMakePalindrome(s.substring(1, n - 1));

            int lasta = s.lastIndexOf(a);
            if (lasta == 0) {
                return 1 + minMovesToMakePalindrome("" + s.charAt(1) + a + s.substring(2, n));
            }
            int firstb = s.indexOf(b);
            if (firstb == n - 1) {
                return 1 + minMovesToMakePalindrome(s.substring(0, n - 2) + b + s.charAt(n - 2));
            }

            if (n - 1 - lasta <= firstb) {
                return n - 1 - lasta + minMovesToMakePalindrome(s.substring(1, lasta) + s.substring(lasta + 1, n));
            } else {
                return firstb + minMovesToMakePalindrome(s.substring(0, firstb) + s.substring(firstb + 1, n - 1));
            }
        }
    }
}
