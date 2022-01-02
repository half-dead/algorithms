package p1000_;

/**
 * https://leetcode.com/problems/bulb-switcher-ii/
 *
 * @author half-dead
 */
public class Puzzle672 {

    class Solution {
        public int flipLights(int n, int m) {
            n = Math.min(n, 3);
            if (n == 0 || m == 0) return 1;
            if (n == 1) return 2;
            if (n == 2) return m == 1 ? 3 : 4;
            return m == 1 ? 4 : (m == 2 ? 7 : 8);
        }
    }
}
