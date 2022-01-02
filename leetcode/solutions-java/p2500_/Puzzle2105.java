package p2500_;

/**
 * https://leetcode.com/problems/watering-plants-ii/
 *
 * @author half-dead
 */
public class Puzzle2105 {

    class Solution {
        public int minimumRefill(int[] plants, int ca, int cb) {
            int i = 0, j = plants.length - 1, res = 0, a = ca, b = cb;

            while (i < j) {
                if (a < plants[i]) {
                    res++;
                    a = ca;
                }
                a -= plants[i++];

                if (b < plants[j]) {
                    res++;
                    b = cb;
                }
                b -= plants[j--];
            }
            if (i == j && Math.max(a, b) < plants[i]) res++;
            return res;
        }
    }
}
