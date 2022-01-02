package p1000_;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/car-fleet/
 *
 * @author half-dead
 */
public class Puzzle853_CarFleet {
    public static void main(String[] args) {
        Solution s = new Puzzle853_CarFleet().new Solution();
//        System.out.println(s.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
        System.out.println(s.carFleet(10, new int[]{2, 4}, new int[]{3, 2}));
    }

    // Counting sort
    class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            int[] map = new int[target + 1];
            for (int i = 0; i < position.length; i++) map[position[i]] = speed[i];

            int count = 0;
            for (int i = target; i >= 0; ) {
                if (map[i] > 0) {
                    double time = (target - i) / (double) map[i];
                    int j = i - 1;
                    while (j >= 0) {
                        if (map[j] > 0 && j + time * map[j] < target) break;
                        else j--;
                    }
                    i = j >= 0 ? j + 1 : 0;
                    count++;
                }
                i--;
            }
            return count;
        }
    }

    class PriorityQueueSolution {
        public int carFleet(int target, int[] position, int[] speed) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < position.length; i++) {
                pq.add(position[i]);
                map.put(position[i], speed[i]);
            }

            int count = 0;
            while (pq.size() > 0) {
                int pos = pq.poll();
                double time = (target - pos) / (double) map.get(pos);
                while (pq.size() > 0) {
                    int p = pq.peek();
                    if (p + time * map.get(p) >= target) pq.poll();
                    else break;
                }
                count++;
            }
            return count;
        }
    }
}
