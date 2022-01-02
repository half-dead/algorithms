package p1000_;

/**
 * https://leetcode.com/problems/super-washing-machines/
 *
 * @author half-dead
 */
public class Puzzle517 {

    class Solution {
        public int findMinMoves(int[] machines) {
            int sum = 0, n = machines.length;
            for (int m : machines) sum += m;
            if (sum % n != 0) return -1;

            int avg = sum / n, res = 0, max = 0, extra = 0;
            for (int m : machines) {
                max = Math.max(max, m);
                extra += m - avg;
                res = Math.max(res, Math.abs(extra));
            }
            return Math.max(res, max - avg);
        }

    }


}
