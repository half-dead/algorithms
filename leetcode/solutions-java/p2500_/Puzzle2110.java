package p2500_;

/**
 * https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/
 *
 * @author half-dead
 */
public class Puzzle2110 {

    class Solution {
        public long getDescentPeriods(int[] prices) {
            long res = 0L;
            for (int i = 0, p = 0, n = prices.length; i <= n; i++) {
                if (p == 0) {
                    p = 1;
                } else if (i < n && prices[i - 1] - 1 == prices[i]) {
                    p++;
                } else {
                    res += (long) p * (p + 1) / 2;
                    p = 1;
                }
            }
            return res;
        }
    }
}
