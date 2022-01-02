package p2000_;

/**
 * https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/
 *
 * @author half-dead
 */
public class Puzzle1869 {

    class Solution {
        public boolean checkZeroOnes(String s) {
            int m0 = 0, m1 = 0, c0 = 0, c1 = 0;
            for (int i = 0, n = s.length(); i < n; i++) {
                if (s.charAt(i) == '0') {
                    m0 = Math.max(m0, ++c0);
                    c1 = 0;
                } else {
                    m1 = Math.max(m1, ++c1);
                    c0 = 0;
                }
            }
            return m1 > m0;
        }
    }

}
