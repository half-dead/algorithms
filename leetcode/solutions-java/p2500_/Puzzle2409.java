package p2500_;

/**
 * https://leetcode.com/problems/count-days-spent-together/
 *
 * @author half-dead
 */
public class Puzzle2409 {

    class Solution {
        public int countDaysTogether(String aa, String la, String ab, String lb) {
            if (aa.compareTo(lb) > 0 || la.compareTo(ab) < 0) {
                return 0;
            }

            return Math.min(nthDay(la), nthDay(lb)) - Math.max(nthDay(aa), nthDay(ab)) + 1;
        }

        final int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        private int nthDay(String s) {
            int m = Integer.parseInt(s.substring(0, 2));
            int d = Integer.parseInt(s.substring(3));
            for (int i = 0; i < m - 1; i++) {
                d += days[i];
            }
            return d;
        }
    }
}
