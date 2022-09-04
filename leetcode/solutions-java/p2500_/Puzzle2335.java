package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/
 *
 * @author half-dead
 */
public class Puzzle2335 {

    // greedy
    class Solution {
        public int fillCups(int[] amount) {
            Arrays.sort(amount);
            int a = amount[0], b = amount[1], c = amount[2];
            if (a + b <= c) {
                return c;
            } else {
                int sum = a + b + c;
                return sum / 2 + sum % 2;
            }
        }
    }
}
