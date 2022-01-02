package p2500_;

/**
 * https://leetcode.com/problems/time-needed-to-buy-tickets/
 *
 * @author half-dead
 */
public class Puzzle2073 {

    class Solution {
        public int timeRequiredToBuy(int[] tickets, int k) {
            int t = tickets[k], res = 0;
            for (int i = 0; i < tickets.length; i++) {
                res += Math.min(tickets[i], i > k ? t - 1 : t);
            }
            return res;
        }
    }
}
