package p2500_;

/**
 * https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
 *
 * @author half-dead
 */
public class Puzzle2114 {

    class Solution {
        public int mostWordsFound(String[] sentences) {
            int res = 0;
            for (String s : sentences) {
                int temp = 0;
                for (char c : s.toCharArray()) {
                    if (c == ' ') temp++;
                }
                res = Math.max(res, temp);
            }
            return res + 1;
        }
    }
}
