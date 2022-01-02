package p2000_;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/process-tasks-using-servers/
 *
 * @author half-dead
 */
public class Puzzle1882 {

    class Solution {
        public int[] assignTasks(int[] servers, int[] tasks) {
            int m = servers.length, n = tasks.length;

            PriorityQueue<Integer> freeServers = new PriorityQueue<>((a, b) -> {
                int d = servers[a] - servers[b];
                return d == 0 ? a - b : d;
            });
            for (int i = 0; i < m; i++) freeServers.offer(i);

            PriorityQueue<int[]> ongoingTasks = new PriorityQueue<>((a, b) -> {
                int d = a[0] - b[0];
                if (d != 0) return d;

                d = servers[a[1]] - servers[b[1]];
                return d == 0 ? a[1] - b[1] : d;
            });

            int[] ans = new int[n];
            int time = 0;
            for (int i = 0; i < n; i++) {
                while (ongoingTasks.size() > 0 && ongoingTasks.peek()[0] <= i) {
                    freeServers.offer(ongoingTasks.poll()[1]);
                }
                if (freeServers.size() == 0) {
                    int[] xx = ongoingTasks.poll();
                    time = xx[0];
                    ans[i] = xx[1];
                } else {
                    ans[i] = freeServers.poll();
                }
                ongoingTasks.offer(new int[]{Math.max(i, time) + tasks[i], ans[i]});
            }
            return ans;
        }
    }
}
