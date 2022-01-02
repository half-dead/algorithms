/*
https://leetcode.com/problems/longest-palindromic-substring/description/

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:
    Input: "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.
Example 2:
    Input: "cbbd"
    Output: "bb"
 */

package p0500_;

/**
 * @author half-dead
 */
public class Puzzle005_LongestPalindromeSubstring {
    public static void main(String[] args) {
        Puzzle005_LongestPalindromeSubstring p = new Puzzle005_LongestPalindromeSubstring();
        Solution solution = p.new Solution();
        String result = solution.longestPalindrome("12145bcb541212");
        System.out.println(result);
    }

    class Solution {
        public String longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            int len = s.length();
            int max = 1, index = 0;
            for (int i = 0; i < len; i++) {
                int left = i, right = i;
                while (left >= 0 && right < len && chars[left] == chars[right]) {
                    left--;
                    right++;
                }
                left++;
                right--;
                int plen = right - left + 1;
                if (max < plen) {
                    max = plen;
                    index = left;
                }
                if (max / 2 + 1 >= len - i) {
                    break;
                }
            }

            for (int i = max / 2; i < len - 1; i++) {
                int left = i, right = i + 1;
                while (left >= 0 && right < len && chars[left] == chars[right]) {
                    left--;
                    right++;
                }
                left++;
                right--;
                int plen = right - left + 1;
                if (max < plen) {
                    max = plen;
                    index = left;
                }
                if (max / 2 >= len - i) {
                    break;
                }
            }
            return s.substring(index, index + max);
        }
    }
}
