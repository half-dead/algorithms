package p1500_;

/**
 * https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
 *
 * @author half-dead
 */
public class Puzzle1247 {
    class Solution {
        /**
         * if s1.length == s2.length == 2, there are at most 3 cases:
         * <pre>
         *     1. a==b, cost 0 swap
         *     2. a=xx, b=yy or vice versa, cost 1 swap
         *     3. a=xy, b=yx or vice versa, cost 2 swaps
         * </pre>
         * with these 3 cases combined, we can form any string s1 and s2
         */
        public int minimumSwap(String s1, String s2) {
            char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
            int d = 0, x1 = 0, x2 = 0;
            for (int i = 0; i < cs1.length; i++) {
                if (cs1[i] != cs2[i]) {
                    d++;
                    if (cs1[i] == 'x') x1++;
                    else x2++;
                }
            }
            // count(x) is odd, no way to make them equal
            if ((x1 + x2) % 2 == 1) return -1;
            // s1 and s2 are equal
            if (d == 0) return 0;

            // apply xx,yy -> xy,xy first, use one swap to reduce two differences
            int res = Math.abs(x1 - x2) / 2;
            d -= res * 2;
            // xyxy,yxyx is the same as xxyy,yyxx, so we can apply xx,yy -> xy,xy first until there are at most one xy,yx left
            int xxyy = d / 4 * 2;
            // xy,yx cost 2 swaps, and the diff is 2, so 2%4 = 2;
            int xyyx = d % 4;
            return res + xxyy + xyyx;
        }
    }
}
