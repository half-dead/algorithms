package p1000_;

import java.util.*;

/**
 * https://leetcode.com/problems/bus-routes/
 *
 * @author half-dead
 */
public class Puzzle815 {

    class Solution {
        public int numBusesToDestination(int[][] routes, int source, int target) {
            int m = routes.length, n = 0, res = 0;

            Map<Integer, Set<Integer>> g = new HashMap<>();
            for (int i = 0; i < m; i++) {
                n += routes[i].length;
                for (int bs : routes[i]) g.computeIfAbsent(bs, x -> new HashSet<>()).add(i);
            }

            boolean[] taken = new boolean[m];
            Set<Integer> reached = new HashSet<>(n);
            reached.add(source);

            Deque<Integer> q = new LinkedList<>();
            q.addLast(source);
            while (q.size() > 0) {
                int size = q.size();
                while (size-- > 0) {
                    int bs = q.pollFirst();
                    if (bs == target) return res;

                    Set<Integer> transfers = g.get(bs);
                    for (int route : transfers) {
                        if (taken[route]) continue;
                        taken[route] = true;

                        for (int next : routes[route]) {
                            if (next != target && g.get(next).size() == 1) continue;
                            if (reached.add(next)) q.addLast(next);
                        }
                    }
                }
                res++;
            }

            return -1;
        }
    }
}
