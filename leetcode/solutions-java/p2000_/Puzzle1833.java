package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-ice-cream-bars/
 *
 * @author half-dead
 */
public class Puzzle1833 {

    class Solution {
        public int maxIceCream(int[] costs, int coins) {
            Arrays.sort(costs);
            int cnt = 0;
            for (int cost : costs) {
                if (coins >= cost) {
                    coins -= cost;
                    cnt++;
                } else {
                    break;
                }
            }
            return cnt;
        }
    }
}
