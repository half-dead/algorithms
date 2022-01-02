package p2500_;

/**
 * https://leetcode.com/problems/adding-spaces-to-a-string/
 *
 * @author half-dead
 */
public class Puzzle2109 {

    class Solution {
        public String addSpaces(String s, int[] spaces) {
            int n = spaces.length, m = s.length();
            StringBuilder result = new StringBuilder(n + m);

            int i = 0;
            for (int p : spaces) {
                while (i < p) {
                    result.append(s.charAt(i++));
                }
                result.append(' ');
            }
            while (i < m) result.append(s.charAt(i++));
            return result.toString();
        }
    }
}
