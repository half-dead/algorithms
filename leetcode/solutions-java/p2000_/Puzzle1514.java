package p2000_;

import java.util.*;

/**
 * https://leetcode.com/problems/path-with-maximum-probability/
 *
 * @author half-dead
 */
public class Puzzle1514 {

    class Solution {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

            Map<Integer, List<Pair>> g = new HashMap<>();
            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                g.computeIfAbsent(edge[0], (a) -> new ArrayList<>()).add(new Pair(edge[1], succProb[i]));
                g.computeIfAbsent(edge[1], (a) -> new ArrayList<>()).add(new Pair(edge[0], succProb[i]));
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
                double d = p2.sp - p1.sp;
                if (d == 0) return 0;
                return d > 0 ? 1 : -1;
            });
            pq.offer(new Pair(start, 1.0d));
            Set<Integer> seen = new HashSet<>();
            while (pq.size() > 0) {
                Pair top = pq.poll();
                if (top.node == end) {
                    return top.sp;
                }
                seen.add(top.node);
                List<Pair> nexts = g.get(top.node);
                if (nexts != null) {
                    for (Pair p : nexts) {
                        if (!seen.contains(p.node)) {
                            pq.offer(new Pair(p.node, top.sp * p.sp));
                        }
                    }
                }
            }
            return 0;
        }

        class Pair {
            int node;
            double sp;

            Pair(int node, double p) {
                this.node = node;
                this.sp = p;
            }
        }
    }
}
