package p0500_;

/**
 * https://leetcode.com/problems/rectangle-area/
 *
 * @author half-dead
 */
public class Puzzle223 {

    class Solution {
        public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            int x = 0, y = 0, area1 = (C - A) * (D - B), area2 = (G - E) * (H - F);
            if (A <= G && E <= C) x = Math.min(G, C) - Math.max(A, E);
            if (D >= F && H >= B) y = Math.min(D, H) - Math.max(F, B);
            return area1 + area2 - (x * y);
        }
    }
}
