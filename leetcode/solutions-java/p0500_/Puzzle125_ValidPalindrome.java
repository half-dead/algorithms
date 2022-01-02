package p0500_;

// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.
//
// Note:
// Have you consider that the string might be empty? This is a good question to ask during an interview.
//
// For the purpose of this problem, we define empty string as valid palindrome.

/**
 * https://oj.leetcode.com/problems/valid-palindrome/
 */
public class Puzzle125_ValidPalindrome {

    public static void main(String[] args) {
        Puzzle125_ValidPalindrome puzzle125 = new Puzzle125_ValidPalindrome();
        Solution s = puzzle125.new Solution();
        boolean b = s.isPalindrome("aA");
        System.out.println(b);
    }

    public class Solution {
        public boolean isPalindrome(String s) {
            if (s.length() < 2)
                return true;
            char[] chars = s.toCharArray();
            int start = 0, end = chars.length - 1;
            boolean head = true;
            char c1 = ' ';
            while (start <= end) {
                char c = chars[head ? start++ : end--];
                if (c >= 'a' && c <= 'z') {
                    c = (char) (c - 32);
                }
                if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
                    if (head) {
                        c1 = c;
                    } else {
                        if (c != c1) {
                            return false;
                        }
                    }
                    head = !head;
                }
            }
            return true;
        }
    }
}
