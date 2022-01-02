package p2000_;

/**
 * https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/
 *
 * @author half-dead
 */
public class Puzzle1974 {

    class Solution {
        public int minTimeToType(String word) {
            int res = 0, prev = 'a';
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c != prev) {
                    int dis = Math.abs(c - prev);
                    res += Math.min(dis, 26 - dis);
                    prev = c;
                }
            }
            return res + word.length();
        }
    }
}
