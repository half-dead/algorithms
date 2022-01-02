package p2000_;

/**
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses
 *
 * @author half-dead
 */
public class Puzzle1614 {

    class Solution {
        public int maxDepth(String s) {
            int d = 0, res = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') res = Math.max(res, ++d);
                else if (c == ')') d--;
            }
            return res;
        }
    }
}
