package p2500_;

/**
 * https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/
 *
 * @author half-dead
 */
public class Puzzle2087 {

    class Solution {
        public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
            int ans = 0;
            for (int i = startPos[0]; i != homePos[0]; ) {
                i = startPos[0] < homePos[0] ? i + 1 : i - 1;
                ans += rowCosts[i];
            }
            for (int i = startPos[1]; i != homePos[1]; ) {
                i = startPos[1] < homePos[1] ? i + 1 : i - 1;
                ans += colCosts[i];
            }
            return ans;
        }
    }
}
