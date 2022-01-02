package p1500_;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/
 *
 * @author half-dead
 */
public class Puzzle1333 {

    class Solution {
        public List<Integer> filterRestaurants(int[][] rs, int vf, int price, int distance) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
                int d = rs[b][1] - rs[a][1];
                return d == 0 ? rs[b][0] - rs[a][0] : d;
            });
            for (int i = 0; i < rs.length; i++) {
                int[] r = rs[i];
                if ((vf == 0 || r[2] == vf) && r[3] <= price && r[4] <= distance) {
                    pq.offer(i);
                }
            }
            List<Integer> res = new ArrayList<>();
            while (pq.size() > 0) {
                res.add(rs[pq.poll()][0]);
            }
            return res;
        }
    }
}
