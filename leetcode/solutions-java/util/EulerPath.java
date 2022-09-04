package util;

import java.util.*;

/**
 * @author half-dead
 */ // T: type of node id
// E: type of edge id
// Tested by LC 2097
class EulerPath<T, E> {
    private Map<T, List<Object[]>> adj = new HashMap<T, List<Object[]>>();
    private Map<T, Integer> curr;
    private Set<E> vst;
    private List<E> result;

    // 1. For directed graph, each edge has unique edgeId
    // 2. For undirected graph, you need to call link() twice with the same
    // edgeId, as below:
    // addEdge(x, y, 1);
    // addEdge(y, x, 1);
    public void addEdge(T x, T y, E edgeId) {
        adj.computeIfAbsent(x, k -> new ArrayList<>()).add(new Object[]{y, edgeId});
    }

    private void dfs(T x) {
        List<Object[]> children = adj.get(x);
        if (children != null) {
            while (curr.get(x) < children.size()) {
                int index = curr.get(x);
                curr.put(x, index + 1);
                Object[] edge = children.get(index);
                T y = (T) edge[0];
                E edgeId = (E) edge[1];
                if (vst.contains(edgeId)) {
                    continue;
                }
                vst.add(edgeId);
                dfs(y);
                result.add(edgeId);
            }
        }
    }

    public List<E> getEulerPath() {
        T start = adj.keySet().iterator().next();
        return getEulerPath(start);
    }

    // undirected graph: all degree (number of edges for each node) are EVEN or only one node has ODD degree (start node)
    // directed graph: all nodes have out-degree equal to in-degree, or only one node has out-degree = in-degree + 1 (start node)
    public List<E> getEulerPath(T start) {
        vst = new HashSet<E>();
        result = new ArrayList<E>();
        curr = new HashMap<T, Integer>();
        for (T x : adj.keySet()) {
            curr.put(x, 0);
        }
        dfs(start);
        Collections.reverse(result);
        return result;
    }
}
