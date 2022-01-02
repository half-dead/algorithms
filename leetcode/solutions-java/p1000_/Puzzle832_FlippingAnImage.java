package p1000_;

/**
 * https://leetcode.com/problems/flipping-an-image/
 *
 * @author half-dead
 */
public class Puzzle832_FlippingAnImage {
    class Solution {
        public int[][] flipAndInvertImage(int[][] m) {
            int n = m.length;
            for (int[] row : m)
                for (int i = 0; (i << 1) < n; i++)
                    if (row[i] == row[n - 1 - i])
                        row[i] = row[n - 1 - i] ^= 1;
            return m;
        }
    }
}
