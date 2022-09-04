package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author half-dead
 */
class DijkstraLongFaster {
    public static class Edge {
        int to;
        long w;

        public Edge(int to, long w) {
            this.to = to;
            this.w = w;
        }
    }

    public static final long INF = Long.MAX_VALUE / 4;
    public List<Edge>[] adj;

    public DijkstraLongFaster(int n) {
        this.adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
    }

    public void link(int x, int y, long w) {
        adj[x].add(new Edge(y, w));
    }

    public long[] shortestPath(int src) {
        int n = adj.length;
        long[] dist = new long[n];
        boolean[] vst = new boolean[n];
        Arrays.fill(dist, INF);

        PriorityQueue<Edge> q = new PriorityQueue<>((a, b) -> Long.compare(a.w, b.w));
        q.add(new Edge(src, 0));
        dist[src] = 0;

        while (!q.isEmpty()) {
            Edge cur = q.poll();
            if (vst[cur.to]) continue;
            int u = cur.to;
            long w = cur.w;
            vst[u] = true;

            for (Edge e : adj[u]) {
                if (!vst[e.to] && dist[e.to] > w + e.w) {
                    dist[e.to] = w + e.w;
                    q.add(new Edge(e.to, w + e.w));
                }
            }
        }
        return dist;
    }
}
