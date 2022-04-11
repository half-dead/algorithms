package p2500_;

/**
 * https://leetcode.com/problems/maximum-points-in-an-archery-competition/
 *
 * @author half-dead
 */
public class Puzzle2212 {

    class Solution {
        public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
            int N12 = 12, limit = 1 << N12, max = 0;

            int[] bobs = new int[N12], res = new int[N12];
            for (int i = 1; i < N12; i++) bobs[i] = aliceArrows[i] + 1;

            for (int state = 0; state < limit; state++) {
                int[] temp = new int[N12];
                int[] curr = cal(state, bobs, temp);
                if (curr[0] > max && curr[1] <= numArrows) {
                    res = temp;
                    res[0] += numArrows - curr[1];
                    max = curr[0];
                }
            }
            return res;
        }

        int[] cal(int state, int[] bobs, int[] holder) {
            int[] res = new int[2];
            for (int i = 0; state > 0; i++, state >>= 1) {
                if (state % 2 != 0) {
                    res[0] += i;
                    res[1] += bobs[i];
                    holder[i] = bobs[i];
                }
            }
            return res;
        }
    }
}
