package p1500_;

/**
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/
 *
 * @author half-dead
 */
public class Puzzle1422 {
    class Solution {
        public int maxScore(String s) {
            char[] chars = s.toCharArray();
            int t1 = 0, c0 = 0, c1 = 0, max = 0;
            for (char c : chars) if (c == '1') t1++;
            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] == '0') c0++;
                else c1++;
                max = Math.max(max, c0 + t1 - c1);
            }
            return max;
        }
    }
}
