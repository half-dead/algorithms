package p0500_;

// Given two binary strings, return their sum (also a binary string).
//
// For example,
// a = "11"
// b = "1"
// Return "100".

/**
 * https://leetcode.com/problems/add-binary/
 */
public class Puzzle067_AddBinary {
    public class Solution {
        public String addBinary(String a, String b) {
            char[] chars = new char[Math.max(a.length(), b.length()) + 1];
            int i = a.length() - 1, j = b.length() - 1, k = chars.length - 1;
            boolean carry = false;
            while (i >= 0 || j >= 0) {
                char ca = i >= 0 ? a.charAt(i) : '0';
                char cb = j >= 0 ? b.charAt(j) : '0';
                int temp = (ca - '0') + (cb - '0') + (carry ? 1 : 0);
                if (temp > 1) {
                    carry = true;
                    temp -= 2;
                } else {
                    carry = false;
                }
                chars[k--] = (char) (temp + '0');
                i--;
                j--;
            }
            if (carry) {
                chars[k--] = '1';
            }
            return new String(chars, k + 1, chars.length - k - 1);
        }
    }
}
