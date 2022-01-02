package p1500_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/submissions/
 *
 * @author half-dead
 */
public class Puzzle1249 {

    // stack
    class Solution {
        public String minRemoveToMakeValid(String s) {
            char[] cs = s.toCharArray();
            int len = cs.length;
            LinkedList<Integer> stack = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                if (cs[i] == '(') {
                    stack.push(i);
                } else if (cs[i] == ')') {
                    if (stack.isEmpty()) cs[i] = ' ';
                    else stack.pop();
                }
            }
            while (!stack.isEmpty()) cs[stack.pop()] = ' ';
            StringBuilder sb = new StringBuilder();
            for (char c : cs) if (c != ' ') sb.append(c);
            return sb.toString();
        }
    }
}
