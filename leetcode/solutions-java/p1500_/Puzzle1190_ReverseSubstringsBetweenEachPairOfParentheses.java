package p1500_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 *
 * @author half-dead
 */
public class Puzzle1190_ReverseSubstringsBetweenEachPairOfParentheses {
    class Solution {
        public String reverseParentheses(String s) {
            StringBuilder result = new StringBuilder();
            LinkedList<StringBuilder> q = new LinkedList<>();
            for (char c : s.toCharArray())
                if (c >= 'a' && c <= 'z')
                    if (q.size() == 0) result.append(c);
                    else q.peek().append(c);
                else if (c == '(')
                    q.push(new StringBuilder());
                else {
                    StringBuilder top = q.pop().reverse();
                    if (q.size() > 0) q.peek().append(top);
                    else result.append(top);
                }
            return result.toString();
        }
    }

    // checkout this solution, very smart
    // https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/discuss/383670/JavaC%2B%2BPython-Why-not-O(N)
}
