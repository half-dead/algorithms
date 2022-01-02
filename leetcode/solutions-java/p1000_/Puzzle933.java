package p1000_;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-recent-calls/
 *
 * @author half-dead
 */
public class Puzzle933 {
    class RecentCounter {

        private Queue<Integer> q;

        public RecentCounter() {
            q = new LinkedList<>();
        }

        public int ping(int t) {
            q.offer(t);
            int target = t - 3000;
            while (q.peek() < target) q.poll();
            return q.size();
        }
    }
}
