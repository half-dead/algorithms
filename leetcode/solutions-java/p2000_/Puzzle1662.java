package p2000_;

/**
 * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 *
 * @author half-dead
 */
public class Puzzle1662 {

    class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            int n1 = word1.length, n2 = word2.length, i1 = 0, i2 = 0;
            int m1 = word1[0].length(), m2 = word2[0].length(), j1 = 0, j2 = 0;
            while (i1 < n1 && i2 < n2) {
                if (word1[i1].charAt(j1++) != word2[i2].charAt(j2++)) return false;

                if (j1 == m1) {
                    j1 = 0;
                    if (++i1 < n1) m1 = word1[i1].length();
                }
                if (j2 == m2) {
                    j2 = 0;
                    if (++i2 < n2) m2 = word2[i2].length();
                }
            }
            return i1 == n1 && i2 == n2;
        }
    }
}
