package p1500_;

/**
 * https://leetcode.com/problems/remove-palindromic-subsequences/
 *
 * @author half-dead
 */
public class Puzzle1332_RemovePalindromicSubsequences {
    class Solution {
        public int removePalindromeSub(String s) {
            if (s.length() == 0) return 0;
            else if (isPalindrome(s)) return 1;
            else return 2;
        }

        private boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
            return true;
        }

    }
}
