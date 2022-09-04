package p2500_;

/**
 * https://leetcode.com/problems/percentage-of-letter-in-string/
 *
 * @author half-dead
 */
public class Puzzle2278 {

    class Solution {
        public int percentageLetter(String s, char letter) {
            int cnt = 0;
            for (char c : s.toCharArray()) {
                if (c == letter)
                    cnt++;
            }
            return (int) Math.floor(cnt / (double) s.length() * 100);
        }
    }
}
