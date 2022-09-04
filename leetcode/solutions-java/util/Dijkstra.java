package util;

import java.util.*;

/**
 * @author half-dead
 */
class Dijkstra {
    public static class Edge {
        int to;
        int w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    public Map<Integer, List<Edge>> adj = new HashMap<>();

    public void link(int x, int y, int w) {
        adj.computeIfAbsent(x, k -> new ArrayList<>()).add(new Edge(y, w));
    }

    public Map<Integer, Integer> shortestPath(int src) {
        Map<Integer, Integer> dist = new HashMap<>();
        Set<Integer> vst = new HashSet<>();

        PriorityQueue<Edge> q = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
        q.add(new Edge(src, 0));
        dist.put(src, 0);

        while (!q.isEmpty()) {
            Edge cur = q.poll();
            int u = cur.to;
            if (vst.contains(u)) continue;
            int w = cur.w;
            vst.add(u);
            if (adj.containsKey(u)) {
                for (Edge e : adj.get(u)) {
                    if (!vst.contains(e.to) && (!dist.containsKey(e.to) || dist.get(e.to) > w + e.w)) {
                        dist.put(e.to, w + e.w);
                        q.add(new Edge(e.to, w + e.w));
                    }
                }
            }
        }
        return dist;
    }
}
