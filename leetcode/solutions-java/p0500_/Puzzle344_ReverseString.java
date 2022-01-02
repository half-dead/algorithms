package p0500_;

// Write a function that takes a string as input and returns the string reversed.
//
// Example:
// Given s = "hello", return "olleh".

/**
 * https://leetcode.com/problems/reverse-string/
 */
public class Puzzle344_ReverseString {

    public class Solution {
        public String reverseString(String s) {
            if (s.length() < 2) {
                return s;
            }
            char[] chars = s.toCharArray();
            int len = chars.length;
            for (int i = 0; i < len / 2; i++) {
                char c = chars[i];
                chars[i] = chars[len - i - 1];
                chars[len - i - 1] = c;
            }
            return new String(chars);
        }
    }
}
