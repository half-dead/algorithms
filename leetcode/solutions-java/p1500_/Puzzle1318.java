package p1500_;

/**
 * https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
 *
 * @author half-dead
 */
public class Puzzle1318 {
    class Solution {
        int minFlips(int a, int b, int c) {
            return Integer.bitCount((a | b) ^ c) + Integer.bitCount(a & b & ((a | b) ^ c));
        }
    }

    class Solution1 {
        public int minFlips(int a, int b, int c) {
            int flip = 0;
            while (c > 0) {
                int ba = a & 1, bb = b & 1, bc = c & 1;
                if (bc == 1) {
                    if (ba == 0 && bb == 0) flip++;
                } else {
                    if (ba == 1) flip++;
                    if (bb == 1) flip++;
                }
                a >>= 1;
                b >>= 1;
                c >>= 1;
            }
            if (a > 0) flip += Integer.bitCount(a);
            if (b > 0) flip += Integer.bitCount(b);
            return flip;
        }
    }
}
