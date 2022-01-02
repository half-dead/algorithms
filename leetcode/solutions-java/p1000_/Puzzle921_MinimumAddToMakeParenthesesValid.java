package p1000_;

/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 *
 * @author half-dead
 */
public class Puzzle921_MinimumAddToMakeParenthesesValid {
    class Solution {
        public int minAddToMakeValid(String s) {
            int count1 = 0, count2 = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    count1++;
                } else if (count1 > 0) {
                    count1--;
                } else {
                    count2++;
                }
            }
            return count1 + count2;
        }
    }

    class Solution2 {
        public int minAddToMakeValid(String s) {
            int result = 0, netLeft = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    netLeft++;
                } else {
                    netLeft--;
                }
                if (netLeft < 0) {
                    result -= netLeft;
                    netLeft = 0;
                }
            }
            if (netLeft > 0) {
                result += netLeft;
            }
            return result;
        }
    }
}
