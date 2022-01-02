package p1500_;

/**
 * https://leetcode.com/problems/remove-outermost-parentheses/
 *
 * @author half-dead
 */
public class Puzzle1021 {
    class Solution {
        public String removeOuterParentheses(String s) {
            StringBuilder res = new StringBuilder();
            int cnt = 0;
            for (char c : s.toCharArray()) {
                if (c == '(' && cnt++ > 0) res.append(c);
                if (c == ')' && --cnt > 0) res.append(c);
            }
            return res.toString();
        }
    }
}
