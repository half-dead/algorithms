package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make/
 *
 * @author half-dead
 */
public class Puzzle1798 {

    class Solution {
        public int getMaximumConsecutive(int[] coins) {
            Arrays.sort(coins);
            int sum = 1;
            for (int coin : coins) {
                if (coin > sum) {
                    break;
                }
                sum += coin;
            }
            return sum;
        }
    }
}
