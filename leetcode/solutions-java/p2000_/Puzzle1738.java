package p2000_;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/
 *
 * @author half-dead
 */
public class Puzzle1738 {
    class Solution {
        public int kthLargestValue(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length;
            int[][] dp = new int[m][n];

            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    int xor = matrix[r][c];
                    if (r > 0) {
                        xor ^= dp[r - 1][c];
                    }
                    if (c > 0) {
                        xor ^= dp[r][c - 1];
                    }
                    if (r > 0 && c > 0) {
                        xor ^= dp[r - 1][c - 1];
                    }
                    dp[r][c] = xor;
                }
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>(k);
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (pq.size() < k) {
                        pq.offer(dp[r][c]);
                    } else if (dp[r][c] <= pq.peek()) {

                    } else {
                        pq.poll();
                        pq.offer(dp[r][c]);
                    }
                }
            }
            return pq.peek();
        }
    }
}
