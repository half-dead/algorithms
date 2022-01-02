package p2000_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/
 *
 * @author half-dead
 */
public class Puzzle1942 {

    public static void main(String[] args) {
        Solution s = new Puzzle1942().new Solution();
        System.out.println(s.smallestChair(new int[][]{
                {4, 5}, {12, 13}, {5, 6}, {1, 2}, {8, 9}, {9, 10}, {6, 7}, {3, 4}, {7, 8}, {13, 14}, {15, 16}, {14, 15}, {10, 11}, {11, 12}, {2, 3}, {16, 17}
        }, 6));
    }

    class Solution {
        public int smallestChair(int[][] times, int targetFriend) {
            int x = times[targetFriend][0], res = 0;

            Arrays.sort(times, Comparator.comparingInt(a -> a[0]));

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            PriorityQueue<Integer> seats = new PriorityQueue<>();

            for (int[] time : times) {
                int arrival = time[0];

                while (pq.size() > 0 && pq.peek()[0] <= arrival) {
                    seats.offer(pq.poll()[1]);
                }

                int seat = seats.size() > 0 ? seats.poll() : res++;
                if (arrival == x)
                    return seat;

                pq.offer(new int[]{time[1], seat});
            }
            return 0;
        }
    }
}
