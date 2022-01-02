package p2000_;

/**
 * https://leetcode.com/problems/maximum-profit-of-operating-a-centennial-wheel/
 *
 * @author half-dead
 */
public class Puzzle1599 {

    class Solution {
        public int minOperationsMaxProfit(int[] customers, int bc, int rc) {
            if (bc * 4 <= rc) return -1;

            int len = customers.length;
            int maxProfit = Integer.MIN_VALUE, rotations = 0;
            int wait = 0, time = 0, profit = 0;
            while (time < len || wait > 0) {
                if (time < len) wait += customers[time];

                int board = Math.min(wait, 4);
                wait -= board;
                profit += board * bc - rc;
                if (profit > maxProfit) {
                    maxProfit = profit;
                    rotations = time + 1;
                }
                time++;
            }
            return maxProfit > 0 ? rotations : -1;
        }
    }
}
