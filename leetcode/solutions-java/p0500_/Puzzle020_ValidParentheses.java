package p0500_;

// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

import java.util.ArrayDeque;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class Puzzle020_ValidParentheses {
    public class Solution {
        public boolean isValid(String s) {
            char[] chars = s.toCharArray();
            ArrayDeque<Character> queue = new ArrayDeque<>();
            for (char c : chars) {
                Character pop;
                switch (c) {
                    case '(':
                    case '{':
                    case '[':
                        queue.push(c);
                        break;
                    case ')':
                    case '}':
                    case ']':
                        if (queue.size() == 0) {
                            return false;
                        }
                        pop = queue.pop();
                        if ((pop == '(' && c == ')') || (pop == '{' && c == '}') || (pop == '[' && c == ']')) {
                            break;
                        } else {
                            return false;
                        }
                    default:
                        return false;
                }
            }
            return queue.isEmpty();
        }
    }
}
