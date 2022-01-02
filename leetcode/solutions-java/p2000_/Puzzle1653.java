package p2000_;

/**
 * https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/
 *
 * @author half-dead
 */
public class Puzzle1653 {

    class Solution {
        public int minimumDeletions(String s) {
            char[] cs = s.toCharArray();

            int ca = 0, cb = 0;
            // count letter 'a'
            for (char c : cs) if (c == 'a') ca++;

            // we could delete all 'a' or 'b' to make s balanced
            int res = Math.min(ca, cs.length - ca);
            if (res == 0) return res;

            // scan from left to right, try to cut s into two parts at every position
            // the left part is all 'a' -> remove all 'b' from left part, which is cb
            // the right part is all 'b' -> remove all 'a' from right part, which is ca
            for (char c : cs) {
                if (c == 'a') ca--;
                else cb++;
                res = Math.min(res, cb + ca);
            }
            return res;
        }
    }
}
