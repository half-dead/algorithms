package p2000_;

/**
 * https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/
 *
 * @author half-dead
 */
public class Puzzle1884 {

    class Solution {
        public int twoEggDrop(int n) {
            int res = 1, sum = 0;
            while (res <= n) {
                sum += res;
                if (sum >= n) break;
                res++;
            }
            return res;
        }
    }
}
