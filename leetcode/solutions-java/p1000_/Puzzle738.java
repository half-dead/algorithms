package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/monotone-increasing-digits/
 *
 * @author half-dead
 */
public class Puzzle738 {

    class Solution {
        public int monotoneIncreasingDigits(int n) {
            char[] cs = (n + "").toCharArray();
            for (int i = 0; i < cs.length - 1; i++) {
                if (cs[i] > cs[i + 1]) {
                    int j = i + 1;
                    while (j > 0 && cs[j - 1] > cs[j]) cs[--j]--;
                    Arrays.fill(cs, j + 1, cs.length, '9');
                    return Integer.parseInt(new String(cs));
                }
            }
            return n;
        }
    }
}
