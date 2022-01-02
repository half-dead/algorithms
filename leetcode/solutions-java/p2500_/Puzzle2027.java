package p2500_;

/**
 * https://leetcode.com/problems/minimum-moves-to-convert-string/
 *
 * @author half-dead
 */
public class Puzzle2027 {

    class Solution {
        public int minimumMoves(String s) {
            char[] cs = s.toCharArray();
            int i = 0, n = cs.length, res = 0;
            while (i < n) {
                if (cs[i] == 'X') {
                    res++;
                    i += 3;
                } else {
                    i++;
                }
            }
            return res;
        }
    }
}
