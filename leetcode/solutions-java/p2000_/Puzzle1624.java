package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-substring-between-two-equal-characters/
 *
 * @author half-dead
 */
public class Puzzle1624 {

    class Solution {
        public int maxLengthBetweenEqualCharacters(String s) {
            int[] a = new int[128];
            Arrays.fill(a, -1);
            int res = -1, n = s.length();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (a[c] != -1) {
                    res = Math.max(res, i - a[c] - 1);
                } else {
                    a[c] = i;
                }
            }
            return res;
        }
    }
}
