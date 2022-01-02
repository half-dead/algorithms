package p1000_;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-number-of-refueling-stops/
 *
 * @author half-dead
 */
public class Puzzle871 {

    // greedy, priority queue
    class Solution {
        public int minRefuelStops(int target, int fuel, int[][] stations) {
            int n = stations.length, res = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i <= n; i++) {
                int pos = i < n ? stations[i][0] : target;
                while (fuel < pos && pq.size() > 0) {
                    fuel -= pq.poll();
                    res++;
                }

                if (fuel < pos) return -1;
                if (i < n) pq.offer(-stations[i][1]);
            }
            return res;
        }
    }
}
