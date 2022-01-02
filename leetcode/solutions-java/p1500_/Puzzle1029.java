package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-city-scheduling/
 *
 * @author half-dead
 */
public class Puzzle1029 {

    public static void main(String[] args) {
        Solution s = new Puzzle1029().new Solution();
        System.out.println(s.twoCitySchedCost(new int[][]{
                {518, 518}, {71, 971}, {121, 862}, {967, 607}, {138, 754}, {513, 337}, {499, 873}, {337, 387}, {647, 917}, {76, 417}
        }));
    }

    // use partition to split the array, element in the left part is smaller than element in the right part
    class Solution {
        public int twoCitySchedCost(int[][] costs) {
            int cost = 0, n = costs.length / 2, end = costs.length - 1;
            partition(costs, 0, end, n);
            for (int i = 0, j = end; i < n; i++, j--)
                cost += costs[i][0] + costs[j][1];
            return cost;
        }

        private void partition(int[][] costs, int from, int to, int n) {
            if (to <= from) return;

            int mid = (from + to) / 2, left = from, right = to;
            int pivot = costs[mid][0] - costs[mid][1];
            while (left <= right) {
                while (costs[left][0] - costs[left][1] < pivot) left++;
                while (costs[right][0] - costs[right][1] > pivot) right--;
                if (left <= right) {
                    int[] temp = costs[left];
                    costs[left] = costs[right];
                    costs[right] = temp;
                    left++;
                    right--;
                }
            }
            if (left == n) return;
            else if (left < n) partition(costs, left, to, n);
            else partition(costs, from, left - 1, n);
        }
    }

    class SortSolution {
        public int twoCitySchedCost(int[][] costs) {
            Arrays.sort(costs, (m, n) -> (m[0] + n[1]) - (m[1] + n[0]));

            int sum = 0, n = costs.length, half = n >> 1;
            for (int i = 0, j = n - 1; i < half; i++, j--) sum += costs[i][0] + costs[j][1];
            return sum;
        }
    }

    // TODO dp??
    // dp[i][j] represents the cost when considering first (i + j) people in which i people assigned to city A and j people assigned to city B.
    class DpSolution {
        public int twoCitySchedCost(int[][] costs) {
            int n = costs.length / 2;
            int[][] dp = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
                dp[0][i] = dp[0][i - 1] + costs[i - 1][1];
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], dp[i][j - 1] + costs[i + j - 1][1]);
                }
            }
            return dp[n][n];
        }
    }
}
