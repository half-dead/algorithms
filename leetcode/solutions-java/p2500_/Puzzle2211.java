package p2500_;

/**
 * https://leetcode.com/problems/count-collisions-on-a-road/
 *
 * @author half-dead
 */
public class Puzzle2211 {

    class Solution {
        public int countCollisions(String directions) {
            int n = directions.length(), res = 0;
            for (int i = 0, cs = 0, cr = 0; i < n; i++) {
                char d = directions.charAt(i);
                if (d == 'L') {
                    if (cr > 0) {
                        res += cr + 1;
                        cr = 0;
                        cs = 1;
                    } else if (cs > 0) {
                        res++;
                    }
                } else if (d == 'R') {
                    cr++;
                    cs = 0;
                } else if (d == 'S') {
                    res += cr;
                    cr = 0;
                    cs = 1;
                }
            }
            return res;
        }
    }
}
