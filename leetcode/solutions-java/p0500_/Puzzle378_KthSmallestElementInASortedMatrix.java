package p0500_;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * @author half-dead
 */
public class Puzzle378_KthSmallestElementInASortedMatrix {

    public static void main(String[] args) {
        Puzzle378_KthSmallestElementInASortedMatrix p = new Puzzle378_KthSmallestElementInASortedMatrix();
        Solution s = p.new Solution();
        int r = s.kthSmallest(new int[][]{{1, 2}, {3, 3}}, 4);
        System.out.println(r);
    }

    // another kind of binary search, Neat Solution
    public class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int len = matrix.length;
            int min = matrix[0][0], max = matrix[len - 1][len - 1] + 1;
            while (min < max) {
                int mid = min + (max - min) / 2;
                int count = 0, j = len - 1;
                for (int[] row : matrix) {
                    while (j >= 0 && row[j] > mid) {
                        j--;
                    }
                    count += (j + 1);
                }
                if (count < k) {
                    min = mid + 1;
                } else {
                    max = mid;
                }
            }
            return min;
        }
    }

    class QueueSolution {
        public int kthSmallest(int[][] matrix, int k) {
            int len = matrix.length;

            PriorityQueue<P> q = new PriorityQueue<>((p1, p2) -> {
                return p1.val - p2.val;
            });
            q.add(new P(matrix[0][0], 0, 0));

            boolean[][] visited = new boolean[len][len];
            visited[0][0] = true;

            while (k > 1) {
                P p = q.poll();
                if (p.r + 1 < len && !visited[p.r + 1][p.c]) {
                    visited[p.r + 1][p.c] = true;
                    q.add(new P(matrix[p.r + 1][p.c], p.r + 1, p.c));
                }
                if (p.c + 1 < len && !visited[p.r][p.c + 1]) {
                    visited[p.r][p.c + 1] = true;
                    q.add(new P(matrix[p.r][p.c + 1], p.r, p.c + 1));
                }
                k--;
            }
            return q.peek().val;
        }
    }

    class P {
        int val, r, c;

        public P(int val, int r, int c) {
            this.val = val;
            this.r = r;
            this.c = c;
        }
    }

}
