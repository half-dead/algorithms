package p1000_;

/**
 * https://leetcode.com/problems/di-string-match/
 *
 * @author half-dead
 */
public class Puzzle942_DIStringMatch {

    class Solution {
        public int[] diStringMatch(String s) {
            int[] result = new int[s.length() + 1];
            int min = 0, max = s.length(), i = 0;
            for (char c : s.toCharArray()) result[i++] = c == 'I' ? min++ : max--;
            result[i] = min;
            return result;
        }
    }
}
