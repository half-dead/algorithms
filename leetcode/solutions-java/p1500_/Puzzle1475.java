package p1500_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 *
 * @author half-dead
 */
public class Puzzle1475 {


    // monotonic stack
    class Solution {
        public int[] finalPrices(int[] prices) {
            int n = prices.length;
            int[] res = new int[n];
            LinkedList<Integer> q = new LinkedList<>();
            q.offer(0);
            for (int i = n - 1; i >= 0; i--) {
                while (q.size() > 0 && q.peek() > prices[i]) q.pop();
                res[i] = prices[i] - q.peek();
                q.push(prices[i]);
            }
            return res;
        }
    }
}
