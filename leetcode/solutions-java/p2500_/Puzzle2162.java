package p2500_;

/**
 * https://leetcode.com/problems/minimum-cost-to-set-cooking-time/
 *
 * @author half-dead
 */
public class Puzzle2162 {

    class Solution {
        public int minCostSetTime(int start, int move, int push, int target) {
            int minute = target / 60, second = target % 60;
            return Math.min(cost(start, move, push, minute, second),
                    cost(start, move, push, minute - 1, second + 60));
        }

        int cost(int start, int move, int push, int m, int s) {
            if (m < 0 || m > 99 || s > 99) return Integer.MAX_VALUE;

            int[] t = new int[4];
            t[0] = m / 10;
            t[1] = m % 10;
            t[2] = s / 10;
            t[3] = s % 10;

            int pos = start, res = 0;
            for (int i = 0; i < 4; i++) {
                if (res == 0 && t[i] == 0) continue;
                if (t[i] != pos) {
                    res += move;
                    pos = t[i];
                }
                res += push;
            }
            return res;
        }
    }
}
