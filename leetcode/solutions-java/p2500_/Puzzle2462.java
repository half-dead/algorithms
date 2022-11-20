package p2500_;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/total-cost-to-hire-k-workers/description/
 */
public class Puzzle2462 {
    class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            long res = 0L;
            int n = costs.length;
            if ((k + candidates * 2) >= n) {
                Arrays.sort(costs);
                for (int i = 0; i < k; i++) {
                    res += costs[i];
                }
                return res;
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? (a[1] - b[1]) : a[0] - b[0]);

            int lo = 0, hi = costs.length - 1;
            while (lo < candidates) {
                pq.offer(new int[]{costs[lo], lo++});
            }
            while (hi >= Math.max(lo, costs.length - candidates)) {
                pq.offer(new int[]{costs[hi], hi--});
            }

            while (k-- > 0) {
                int[] top = pq.poll();
                res += top[0];
                if (lo <= hi) {
                    if (top[1] < lo) {
                        pq.offer(new int[]{costs[lo], lo++});
                    } else {
                        pq.offer(new int[]{costs[hi], hi--});
                    }
                }
            }
            return res;
        }
    }
}
