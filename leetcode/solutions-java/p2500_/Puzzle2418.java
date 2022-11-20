package p2500_;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/sort-the-people/
 */
public class Puzzle2418 {

    class Solution {
        public String[] sortPeople(String[] names, int[] heights) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> heights[b] - heights[a]);
            for (int i = 0; i < heights.length; i++) {
                pq.offer(i);
            }

            String[] res = new String[heights.length];
            int i = 0;
            while (pq.size() > 0) {
                res[i++] = names[pq.poll()];
            }
            return res;
        }
    }
}
