package p0500_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 *
 * @author half-dead
 */
public class Puzzle316 {

    class Solution {
        public String removeDuplicateLetters(String s) {
            char[] cs = s.toCharArray();
            int len = cs.length;

            int[] last = new int[128];
            for (int i = 0; i < len; i++) last[cs[i]] = i;

            boolean[] seen = new boolean[128];
            LinkedList<Character> stack = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                char c = cs[i];
                if (seen[c]) continue;

                while (!stack.isEmpty() && c < stack.peek() && i < last[stack.peek()]) {
                    seen[stack.pop()] = false;
                }

                stack.push(c);
                seen[c] = true;
            }

            StringBuilder sb = new StringBuilder();
            for (char c : stack) sb.append(c);
            return sb.reverse().toString();
        }
    }
}
