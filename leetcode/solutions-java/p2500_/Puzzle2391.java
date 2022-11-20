package p2500_;

/**
 * https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/description/
 */
public class Puzzle2391 {

    class Solution {
        public int garbageCollection(String[] gc, int[] travel) {
            int n = gc.length, total = 0;

            int[] last = new int[3];
            for (int i = 0; i < n; i++) {
                String g = gc[i];
                if (g.indexOf('M') >= 0) last[0] = i;
                if (g.indexOf('P') >= 0) last[1] = i;
                if (g.indexOf('G') >= 0) last[2] = i;
                total += g.length();
            }

            for (int type = 0; type < 3; type++) {
                for (int i = 0; i < n; i++) {
                    if (i > last[type]) break;

                    if (i > 0) total += travel[i - 1];
                }
            }
            return total;
        }
    }

    // loop backwards & use prefix sum.
    class Solution2 {
        public int garbageCollection(String[] garbage, int[] travel) {
            for (int i = 1; i < travel.length; i++) {
                travel[i] += travel[i - 1];
            }

            int total = 0;
            boolean m = true, g = true, p = true;

            for (int i = garbage.length - 1; i > 0; i--) {

                if (m && garbage[i].contains("M")) {
                    total += travel[i - 1];
                    m = false;
                }

                if (g && garbage[i].contains("G")) {
                    total += travel[i - 1];
                    g = false;
                }

                if (p && garbage[i].contains("P")) {
                    total += travel[i - 1];
                    p = false;
                }
                total += garbage[i].length();
            }

            total += garbage[0].length();
            return total;
        }
    }
}
