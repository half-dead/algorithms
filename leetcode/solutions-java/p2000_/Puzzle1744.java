package p2000_;

/**
 * https://leetcode.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/
 *
 * @author half-dead
 */
public class Puzzle1744 {

    class Solution {
        public boolean[] canEat(int[] candies, int[][] queries) {
            int qlen = queries.length, clen = candies.length;

            long[] ps = new long[clen + 1];
            for (int i = 0; i < clen; i++) ps[i + 1] = ps[i] + candies[i];

            boolean[] res = new boolean[qlen];
            for (int i = 0; i < qlen; i++) {
                int[] q = queries[i];
                int type = q[0];
                long day = q[1], cap = q[2];
                long min = day + 1, max = (day + 1) * cap;
                res[i] = ps[type] + 1 <= max && min <= ps[type + 1];
            }
            return res;
        }
    }
}
