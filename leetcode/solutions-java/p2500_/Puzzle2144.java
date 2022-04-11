package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/submissions/
 *
 * @author half-dead
 */
public class Puzzle2144 {
    class Solution {
        public int minimumCost(int[] cost) {
            Arrays.sort(cost);
            int n = cost.length;
            int res = 0;
            for (int i = n - 1; i >= 0; i -= 3) {
                res += cost[i];
                if (i > 0) {
                    res += cost[i - 1];
                }
            }
            return res;
        }
    }
}
