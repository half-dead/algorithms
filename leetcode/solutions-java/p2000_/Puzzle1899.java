package p2000_;

/**
 * @author half-dead
 */
public class Puzzle1899 {

    // greedy
    class Solution {
        public boolean mergeTriplets(int[][] triplets, int[] target) {
            int x = target[0], y = target[1], z = target[2];
            boolean cx = false, cy = false, cz = false;
            for (int[] t : triplets) {
                if (t[0] == x && t[1] <= y && t[2] <= z) cx = true;
                if (t[1] == y && t[0] <= x && t[2] <= z) cy = true;
                if (t[2] == z && t[0] <= x && t[1] <= y) cz = true;
            }
            return cx && cy && cz;
        }
    }
}
