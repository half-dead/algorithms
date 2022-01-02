package p0500_;

// Determine whether an integer is a palindrome. Do this without extra space.
//
// Some hints:
// Could negative integers be palindromes? (ie, -1)
//
// If you are thinking of converting the integer to string, note the restriction of using extra space.
//
// You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
//
// There is a more generic way of solving this problem.

/**
 * https://oj.leetcode.com/problems/palindrome-number/
 */
public class Puzzle009_PalindromeNumber {

    public class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            if (x < 10) {
                return true;
            }
            if (x % 10 == 0) {
                return false;
            }
            char[] chars = new char[(int) Math.floor(Math.log10(x)) + 1];
            int i = 0;
            while (x != 0) {
                chars[i++] = (char) ('0' + x % 10);
                x /= 10;
            }
            int m = 0, n = chars.length - 1;
            while (m <= n) {
                if (chars[m++] != chars[n--]) {
                    return false;
                }
            }
            return true;
        }
    }
}
