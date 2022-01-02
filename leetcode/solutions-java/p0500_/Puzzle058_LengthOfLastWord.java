package p0500_;

// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
//
// If the last word does not exist, return 0.
//
// Note: A word is defined as a character sequence consists of non-space characters only.
//
// For example,
// Given s = "Hello World",
// return 5.

/**
 * https://oj.leetcode.com/problems/length-of-last-word/
 */
public class Puzzle058_LengthOfLastWord {

    public class Solution {
        public int lengthOfLastWord(String s) {
            char[] chars = s.toCharArray();
            int j = 0;
            for (int i = chars.length - 1; i > -1; i--) {
                char c = chars[i];
                if (c == ' ') {
                    if (j == 0) continue;
                    else break;
                } else {
                    j++;
                }
            }
            return j;
        }
    }
}
