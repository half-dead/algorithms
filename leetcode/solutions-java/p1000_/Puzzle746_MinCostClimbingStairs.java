package p1000_;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 *
 * @author half-dead
 */
public class Puzzle746_MinCostClimbingStairs {

    public static void main(String[] args) {
        Puzzle746_MinCostClimbingStairs p = new Puzzle746_MinCostClimbingStairs();
        Solution solution = p.new Solution();
        int cost = solution.minCostClimbingStairs(new int[]{0, 0, 1, 1});
        System.out.println(cost);
    }

    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int[] dp = new int[cost.length + 1];
            dp[0] = cost[0];
            dp[1] = cost[1];
            for (int i = 2; i < dp.length; i++) {
                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + (i < cost.length ? cost[i] : 0);
            }
            return dp[dp.length - 1];
        }
    }
}
