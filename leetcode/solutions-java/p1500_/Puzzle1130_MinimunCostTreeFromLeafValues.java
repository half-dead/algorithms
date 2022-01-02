package p1500_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
 *
 * @author half-dead
 */
public class Puzzle1130_MinimunCostTreeFromLeafValues {
    public static void main(String[] args) {
        DpSolution s1 = new Puzzle1130_MinimunCostTreeFromLeafValues().new DpSolution();
        Solution s2 = new Puzzle1130_MinimunCostTreeFromLeafValues().new Solution();
        System.out.println(s1.mctFromLeafValues(new int[]{1, 3, 9, 7, 5, 10, 4, 6, 2, 8}));
        System.out.println(s2.mctFromLeafValues(new int[]{1, 3, 9, 7, 5, 10, 4, 6, 2, 8}));
    }

    // the stack stores elements in decreasing order, O(N) space, O(N) time
    class Solution {
        public int mctFromLeafValues(int[] arr) {
            int sum = 0;
            LinkedList<Integer> q = new LinkedList<>();
            for (int i : arr) {
                while (q.size() > 0 && q.peek() <= i)
                    sum += q.pop() * (q.size() > 0 ? Math.min(q.peek(), i) : i);
                q.push(i);
            }
            while (q.size() > 1) sum += q.pop() * q.peek();
            return sum;
        }
    }

    // Dp Solution, O(N^3) time, O(N^2) space, not good enough
    class DpSolution {
        public int mctFromLeafValues(int[] arr) {
            int len = arr.length;
            int[][] rangeMax = new int[len][len], dp = new int[len][len];
            for (int d = 0; d < len; d++)
                for (int i = 0; i + d < len; i++)
                    rangeMax[i][i + d] = d == 0 ? arr[i] : Math.max(rangeMax[i][i], rangeMax[i + 1][i + d]);

            int count = 0;
            for (int d = 1; d < len; d++) {
                for (int i = 0; i + d < len; i++) {
                    int min = Integer.MAX_VALUE;
                    for (int j = i + 1; j <= i + d; j++) {
                        min = Math.min(min, dp[i][j - 1] + dp[j][i + d] + rangeMax[i][j - 1] * rangeMax[j][i + d]);
                        count++;
                    }
                    dp[i][i + d] = min;
                }
            }
            return dp[0][len - 1];
        }
    }
}
