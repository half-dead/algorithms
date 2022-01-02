package p1500_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 *
 * @author half-dead
 */
public class Puzzle1081 {
    public static void main(String[] args) {
        Solution s = new Puzzle1081().new Solution();
        System.out.println(s.smallestSubsequence("cdadabcc")); // adbc
        System.out.println(s.smallestSubsequence("ecbacba")); // eacb
        System.out.println(s.smallestSubsequence("leetcode")); // letcod
        System.out.println(s.smallestSubsequence("ddeeeccdce")); // cde
    }

    class Solution {
        public String smallestSubsequence(String s) {
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
