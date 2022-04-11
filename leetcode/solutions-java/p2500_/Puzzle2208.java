package p2500_;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-operations-to-halve-array-sum/
 *
 * @author half-dead
 */
public class Puzzle2208 {

    class Solution {
        public int halveArray(int[] nums) {
            PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));
            long sum = 0;
            for (int x : nums) {
                pq.offer((double) x);
                sum += x;
            }

            double d = 0, target = sum / 2.0d;
            int res = 0;
            while (d < target) {
                double x = pq.poll();
                x /= 2;
                d += x;
                pq.offer(x);
                res++;
            }
            return res;
        }
    }
}
