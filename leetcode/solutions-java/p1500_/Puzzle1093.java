package p1500_;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/statistics-from-a-large-sample/
 *
 * @author half-dead
 */
public class Puzzle1093 {

    class Solution {
        public double[] sampleStats(int[] count) {
            int min = 255, max = 0, maxfreq = 0, mode = 0;
            long sum = 0L, samples = 0L;
            for (int i = 0; i <= 255; i++) {
                if (count[i] > 0) {
                    min = Math.min(min, i);
                    max = Math.max(max, i);
                    sum += (long) count[i] * i;
                    samples += count[i];
                    if (count[i] > maxfreq) {
                        maxfreq = count[i];
                        mode = i;
                    }
                }
            }
            double mean = sum / (double) samples, median = 0.0d;
            Deque<int[]> dq = new LinkedList<>();
            for (int i = 0; i <= 255; i++)
                if (count[i] > 0)
                    dq.addLast(new int[]{i, count[i]});

            while (dq.size() > 1) {
                int x = Math.min(dq.peekFirst()[1], dq.peekLast()[1]);
                if (dq.size() == 2 && dq.peekFirst()[1] == dq.peekLast()[1]) {
                    median = ((double) dq.peekFirst()[0] + dq.peekLast()[0]) / 2;
                }
                if ((dq.peekFirst()[1] -= x) == 0) dq.pollFirst();
                if ((dq.peekLast()[1] -= x) == 0) dq.pollLast();
            }
            if (dq.size() > 0) median = dq.peekFirst()[0];
            return new double[]{(double) min, (double) max, mean, median, (double) mode};
        }
    }
}
