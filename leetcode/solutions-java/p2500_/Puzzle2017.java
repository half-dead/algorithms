package p2500_;

/**
 * https://leetcode.com/problems/grid-game/
 *
 * @author half-dead
 */
public class Puzzle2017 {

    class Solution {
        public long gridGame(int[][] grid) {
            long sum0 = 0L, prefixSum0 = 0L, prefixSum1 = 0L, res = Long.MAX_VALUE;
            for (int num : grid[0]) sum0 += num;

            for (int i = 0; i < grid[0].length; i++) {
                prefixSum0 += grid[0][i];
                res = Math.min(res, Math.max(sum0 - prefixSum0, prefixSum1));
                prefixSum1 += grid[1][i];
            }
            return res;
        }
    }
}
