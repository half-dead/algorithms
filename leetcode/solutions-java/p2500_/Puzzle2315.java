package p2500_;

/**
 * https://leetcode.com/problems/count-asterisks/
 *
 * @author half-dead
 */
public class Puzzle2315 {

    class Solution {
        public int countAsterisks(String s) {
            int res = 0;
            boolean b = true;
            for (char c : s.toCharArray()) {
                if (c == '|') {
                    b = !b;
                } else if (b && c == '*') {
                    res++;
                }
            }
            return res;
        }
    }
}
