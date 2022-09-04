package p2500_;

/**
 * https://leetcode.com/problems/calculate-amount-paid-in-taxes/
 *
 * @author half-dead
 */
public class Puzzle2303 {
    class Solution {
        public double calculateTax(int[][] brackets, int income) {
            double res = 0.0d;
            int i = 0, prev = 0;
            while (income > 0) {
                int part = Math.min(income, brackets[i][0] - prev);
                res += ((double) brackets[i][1]) / 100 * part;
                income -= part;
                prev = brackets[i++][0];
            }
            return res;
        }
    }
}
