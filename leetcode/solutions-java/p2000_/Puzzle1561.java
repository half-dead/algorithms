package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
 *
 * @author half-dead
 */
public class Puzzle1561 {

    // greedy
    class Solution {
        public int maxCoins(int[] piles) {
            Arrays.sort(piles);
            int n = piles.length, steps = n / 3, res = 0;
            for (int i = n - 2; i >= steps; i -= 2) res += piles[i];
            return res;
        }
    }
}
