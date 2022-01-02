package p2000_;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/number-of-orders-in-the-backlog/
 *
 * @author half-dead
 */
public class Puzzle1801 {

    public static void main(String[] args) {
        Solution s = new Puzzle1801().new Solution();
        System.out.println(s.getNumberOfBacklogOrders(new int[][]{
                {10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}
        }));
    }

    class Solution {
        public int getNumberOfBacklogOrders(int[][] orders) {
            PriorityQueue<int[]> sq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            PriorityQueue<int[]> bq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            for (int[] order : orders) {
                int price = order[0], amount = order[1];
                if (order[2] == 0) {
                    while (amount > 0 && sq.size() > 0 && sq.peek()[0] <= price) {
                        int execute = Math.min(amount, sq.peek()[1]);
                        amount -= execute;
                        sq.peek()[1] -= execute;
                        if (sq.peek()[1] == 0) sq.poll();
                    }
                    if (amount > 0) {
                        bq.offer(new int[]{price, amount});
                    }
                } else {
                    while (amount > 0 && bq.size() > 0 && bq.peek()[0] >= price) {
                        int execute = Math.min(amount, bq.peek()[1]);
                        amount -= execute;
                        bq.peek()[1] -= execute;
                        if (bq.peek()[1] == 0) bq.poll();
                    }
                    if (amount > 0) {
                        sq.offer(new int[]{price, amount});
                    }
                }
            }
            long res = 0L;
            for (int[] x : sq) res += x[1];
            for (int[] x : bq) res += x[1];
            return (int) (res % 1000000007);
        }
    }
}
