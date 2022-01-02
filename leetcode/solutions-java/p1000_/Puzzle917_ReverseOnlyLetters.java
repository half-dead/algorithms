package p1000_;

/**
 * https://leetcode.com/problems/reverse-only-letters/
 *
 * @author half-dead
 */
public class Puzzle917_ReverseOnlyLetters {
    class Solution {
        public String reverseOnlyLetters(String s) {
            char[] chars = s.toCharArray();
            int left = 0, right = s.length() - 1;
            while (left < right) {
                while (left < right && !isLetter(chars[left])) {
                    left++;
                }
                while (right > left && !isLetter(chars[right])) {
                    right--;
                }
                if (left < right) {
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                }
                left++;
                right--;
            }
            return new String(chars);

        }

        private boolean isLetter(char c) {
            return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
        }
    }
}
