package p2500_;

/**
 * https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/
 *
 * @author half-dead
 */
public class Puzzle2414 {

    class Solution {
        public int longestContinuousSubstring(String s) {
            int res = 1, cnt = 1;
            char prev = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == prev + 1) {
                    res = Math.max(res, ++cnt);
                } else {
                    cnt = 1;
                }
                prev = c;
            }
            return res;
        }
    }
}
