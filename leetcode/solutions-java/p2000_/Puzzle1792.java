package p2000_;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/maximum-average-pass-ratio/
 *
 * @author half-dead
 */
public class Puzzle1792 {

    class Solution {
        public double maxAverageRatio(int[][] classes, int extraStudents) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(classes.length, (a, b) -> {
                double d1 = (a[0] + 1) / (double) (a[1] + 1) - a[0] / (double) a[1];
                double d2 = (b[0] + 1) / (double) (b[1] + 1) - b[0] / (double) b[1];
                return d1 < d2 ? 1 : -1;
            });
            for (int[] c : classes) {
                pq.offer(c);
            }

            while (extraStudents > 0) {
                int[] c = pq.poll();
                c[0]++;
                c[1]++;
                pq.offer(c);
                extraStudents--;
            }

            double sum = 0.0d;
            for (int[] c : pq) {
                sum += c[0] / (double) c[1];
            }
            return sum / classes.length;
        }
    }
}
