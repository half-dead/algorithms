package p1500_;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author half-dead
 */
public class Puzzle1046 {
    public static void main(String[] args) {
        Solution s = new Puzzle1046().new Solution();
        System.out.println(s.lastStoneWeight(new int[]{1, 3}));
    }

    class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int stone : stones) pq.offer(stone);
            while (pq.size() > 1) {
                int diff = pq.poll() - pq.poll();
                while (pq.size() > 0 && diff >= pq.peek()) {
                    diff -= pq.poll();
                }
                pq.offer(diff);
            }
            return pq.poll();
        }
    }
}
