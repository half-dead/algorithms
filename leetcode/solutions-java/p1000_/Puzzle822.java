package p1000_;

/**
 * @author half-dead
 */
public class Puzzle822 {
    class Solution {
        public int flipgame(int[] fronts, int[] backs) {
            int[] state = new int[2001];
            for (int i = 0; i < fronts.length; i++) {
                int f = fronts[i], b = backs[i];
                if (f == b) {
                    state[f] = -1;
                } else {
                    if (state[f] == 0) state[f] = 1;
                    if (state[b] == 0) state[b] = 1;
                }
            }
            for (int i = 0; i < state.length; i++) if (state[i] > 0) return i;
            return 0;
        }
    }

}
