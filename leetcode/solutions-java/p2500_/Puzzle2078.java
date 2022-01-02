package p2500_;

/**
 * https://leetcode.com/problems/two-furthest-houses-with-different-colors/
 *
 * @author half-dead
 */
public class Puzzle2078 {

    class Solution {
        public int maxDistance(int[] colors) {
            int n = colors.length, res = 1;
            for (int i = 0, first = colors[0], last = colors[n - 1]; i < n; i++) {
                if (colors[i] != first)
                    res = Math.max(res, i);
                if (colors[i] != last)
                    res = Math.max(res, n - 1 - i);
            }
            return res;
        }
    }
}
