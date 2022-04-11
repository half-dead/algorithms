package p2000_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-interval-to-include-each-query/
 *
 * @author half-dead
 */
public class Puzzle1851 {

    // sorting, priority queue
    // segment tree also works for this problem
    class Solution {
        public int[] minInterval(int[][] intervals, int[] queries) {
            Arrays.sort(intervals, (a, b) -> {
                int d = a[0] - b[0];
                return d != 0 ? d : a[1] - b[1];
            });
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> (a[1] - a[0])));

            int m = queries.length;
            int[][] q = new int[m][2];
            for (int i = 0; i < m; i++) {
                q[i][0] = i;
                q[i][1] = queries[i];
            }
            Arrays.sort(q, Comparator.comparingInt(a -> a[1]));

            int[] res = new int[m];
            for (int i = 0, j = 0, n = intervals.length; i < m; i++) {
                while (j < n && intervals[j][0] <= q[i][1]) {
                    pq.offer(intervals[j++]);
                }
                while (pq.size() > 0 && pq.peek()[1] < q[i][1]) pq.poll();
                res[q[i][0]] = pq.size() == 0 ? -1 : (pq.peek()[1] - pq.peek()[0] + 1);
            }
            return res;
        }
    }
}
