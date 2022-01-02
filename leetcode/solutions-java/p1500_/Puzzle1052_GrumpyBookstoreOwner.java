package p1500_;

/**
 * https://leetcode.com/problems/grumpy-bookstore-owner/
 *
 * @author half-dead
 */
public class Puzzle1052_GrumpyBookstoreOwner {
    public static void main(String[] args) {
        Solution s = new Puzzle1052_GrumpyBookstoreOwner().new Solution();
        System.out.println(s.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }

    // sliding window solution, O(n) time, O(1) space, 3ms
    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int x) {
            int len = customers.length, satisfied = 0, unsatisfied = 0, maxUnsatisfied = 0;
            for (int i = 0; i < len; i++) {
                if (grumpy[i] == 0) satisfied += customers[i];
                else unsatisfied += customers[i];

                if (i >= x) unsatisfied -= grumpy[i - x] * customers[i - x];
                maxUnsatisfied = Math.max(maxUnsatisfied, unsatisfied);
            }
            return satisfied + maxUnsatisfied;
        }
    }

    // dp solution, O(n) time & space, 3ms
    class DpSolution {
        public int maxSatisfied(int[] customers, int[] grumpy, int x) {
            int len = customers.length;
            int[] temp = new int[len], dp = new int[len];
            for (int i = 0; i < len; i++)
                temp[i] = (i == 0 ? 0 : temp[i - 1]) + customers[i] - (i < x ? 0 : customers[i - x]);

            int n1 = temp[x - 1], n2 = n1;
            for (int i = 0; i < len; i++) {
                int cur = grumpy[i] == 1 ? 0 : customers[i];
                dp[i] = i == 0 ? cur : (cur + dp[i - 1]);
                if (i >= x) {
                    n1 = Math.max(n1, n2) + cur;
                    n2 = temp[i] + dp[i - x];
                }
            }
            return Math.max(Math.max(n1, n2), dp[len - 1]);
        }
    }
}
