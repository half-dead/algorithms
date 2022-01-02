package p1000_;

/**
 * https://leetcode.com/problems/image-overlap/
 *
 * @author half-dead
 */
public class Puzzle835 {
    class Solution {
        public int largestOverlap(int[][] A, int[][] B) {
            int n = A.length, max = 0;

            for (int ra = 0; ra < n; ra++) {
                for (int ca = 0; ca < n; ca++) {
                    if (A[ra][ca] == 1) {

                        for (int rb = 0; rb < n; rb++) {
                            for (int cb = 0; cb < n; cb++) {
                                if (B[rb][cb] == 1) {

                                }
                            }
                        }

                    }
                }
            }


            return max;
        }
    }
}
