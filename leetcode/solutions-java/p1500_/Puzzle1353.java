package p1500_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
 *
 * @author half-dead
 */
public class Puzzle1353 {

    public static void main(String[] args) {

        Solution s = new Puzzle1353().new Solution();
        System.out.println(s.maxEvents(new int[][]{{27, 27}, {8, 10}, {9, 11}, {20, 21}, {25, 29}, {17, 20}, {12, 12}, {12, 12}, {10, 14}, {7, 7}, {6, 10}, {7, 7}, {4, 8}, {30, 31}, {23, 25}, {4, 6}, {17, 17}, {13, 14}, {6, 9}, {13, 14}}));
    }

    class Solution {
        public int maxEvents(int[][] events) {
            Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                int d = a[1] - b[1];
                return d == 0 ? a[0] - b[0] : d;
            });

            int i = 0, day = 1, n = events.length, res = 0;
            while (i < n) {
                int currDay = events[i][0];
                while (i < n && events[i][0] == currDay) pq.offer(events[i++]);

                int nextDay = i < n ? events[i][0] : Integer.MAX_VALUE;
                while (pq.size() > 0 && day < nextDay && pq.peek()[0] < nextDay) {
                    int[] event = pq.poll();
                    if (day <= event[1]) {
                        day = Math.max(event[0] + 1, day + 1);
                        res++;
                    }
                }
            }
            return res;
        }
    }

    class Solution1 {
        public int maxEvents(int[][] events) {
            Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            int i = 0, day = 0, n = events.length, res = 0;
            while (pq.size() > 0 || i < n) {
                if (pq.isEmpty()) day = events[i][0];

                while (i < n && events[i][0] <= day) pq.offer(events[i++][1]);

                pq.poll();
                day++;
                res++;

                while (!pq.isEmpty() && pq.peek() < day) pq.poll();
            }
            return res;
        }
    }
}
