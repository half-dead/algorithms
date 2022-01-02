package p2000_;

/**
 * https://leetcode.com/problems/delete-characters-to-make-fancy-string/
 *
 * @author half-dead
 */
public class Puzzle1957 {

    class Solution {
        public String makeFancyString(String s) {
            StringBuilder sb = new StringBuilder();
            char prev = ' ';
            int cnt = 0;
            for (int i = 0, n = s.length(); i < n; i++) {
                char c = s.charAt(i);
                if (c == prev) {
                    if (++cnt < 3) sb.append(c);
                } else {
                    prev = c;
                    cnt = 1;
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
}
