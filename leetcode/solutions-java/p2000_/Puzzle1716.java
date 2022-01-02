package p2000_;

/**
 * https://leetcode.com/problems/calculate-money-in-leetcode-bank/
 *
 * @author half-dead
 */
public class Puzzle1716 {

    class Solution {
        public int totalMoney(int n) {
            int mod = n % 7;
            n /= 7;
            return n * 28
                    + 7 * n * (n - 1) / 2
                    + n * mod
                    + mod * (mod + 1) / 2;
        }
    }
}
