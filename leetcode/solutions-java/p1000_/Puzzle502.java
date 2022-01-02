package p1000_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/ipo/
 *
 * @author half-dead
 */
public class Puzzle502 {

    class Solution {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            int n = profits.length, j = 0;
            int[][] cp = new int[n][2];
            for (int i = 0; i < n; i++) cp[i] = new int[]{capital[i], profits[i]};

            Arrays.sort(cp, Comparator.comparingInt(x -> x[0]));
            PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);

            while (k > 0) {
                while (j < n && cp[j][0] <= w) pq.offer(cp[j++][1]);

                if (pq.size() == 0) break;
                w += pq.poll();
                k--;
            }
            return w;
        }
    }
}
