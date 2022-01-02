package p1500_;

/**
 * https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 *
 * @author half-dead
 */
public class Puzzle1111 {

    class Solution {
        public int[] maxDepthAfterSplit(String seq) {
            char[] cs = seq.toCharArray();
            int len = cs.length, open = 0, depth = 0;
            for (char c : cs) {
                if (c == '(') {
                    depth = Math.max(depth, ++open);
                } else {
                    open--;
                }
            }

            depth = (depth + 1) >> 1;
            open = 0;
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                if (cs[i] == '(') {
                    if (open++ >= depth)
                        res[i] = 1;
                } else {
                    if (--open >= depth)
                        res[i] = 1;
                }
            }
            return res;
        }
    }
}
