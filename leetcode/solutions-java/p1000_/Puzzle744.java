package p1000_;

/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 *
 * @author half-dead
 */
public class Puzzle744 {
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            boolean[] b = new boolean[26];
            for (char c : letters) b[c - 'a'] = true;
            for (int idx = target - 'a' + 1; ; idx++) {
                if (b[idx % 26]) return (char) ('a' + idx);
            }
        }
    }
}
