package p1000_;

/**
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 *
 * @author half-dead
 */
public class Puzzle983_MinimumCostForTickets {

    public static void main(String[] args) {

        Puzzle983_MinimumCostForTickets p = new Puzzle983_MinimumCostForTickets();
        Solution s = p.new Solution();
        s.mincostTickets(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31},
                new int[]{2, 7, 15}
        );
    }

    class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            int max = days[days.length - 1] + 1;
            int[] dp = new int[max];
            int dayIndex = 0;
            for (int i = 1; i < max; i++) {
                int day = days[dayIndex];
                while (i < day) {
                    dp[i] = dp[i - 1];
                    i++;
                }
                dp[i] = Math.min(dp[i - 1] + costs[0], dp[i >= 7 ? i - 7 : 0] + costs[1]);
                dp[i] = Math.min(dp[i >= 30 ? i - 30 : 0] + costs[2], dp[i]);
                if (++dayIndex == days.length) {
                    break;
                }
            }
            return dp[days[days.length - 1]];
        }
    }
}
