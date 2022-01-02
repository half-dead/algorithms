package p2000_;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-number-of-work-sessions-to-finish-the-tasks/
 *
 * @author half-dead
 */
public class Puzzle1986 {

    public static void main(String[] args) {
        Solution s = new Puzzle1986().new Solution();
        System.out.println(s.minSessions(new int[]{8, 3, 9}, 11));
    }

    // greedy, not correct.
    class Solution {
        public int minSessions(int[] tasks, int sessionTime) {
            int sum = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a), next;
            for (int h : tasks) {
                sum += h;
                pq.offer(h);
            }

            int rest = sessionTime, ans = 0;
            while (sum > 0) {
                next = new PriorityQueue<>((a, b) -> b - a);
                while (pq.size() > 0) {
                    if (pq.peek() > rest) next.offer(pq.poll());
                    else rest -= pq.poll();
                }

                pq = next;
                sum -= (sessionTime - rest);
                rest = sessionTime;
                ans++;
            }
            return ans;
        }
    }
}
