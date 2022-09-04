package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author half-dead
 */
class GraphIntegerFaster {
    public List<Integer>[] adj;

    public GraphIntegerFaster(int n) {
        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
    }

    // directed edge x -> y
    public void link(int x, int y) {
        adj[x].add(y);
    }

    public List<Integer> getChildren(int x) {
        return adj[x];
    }

    private static final int TEMPORARY = 1;
    private static final int PERMANENT = 2;

    // x -> y means x should be processed before y
    // The input is a directed graph.
    // 1. return null, means there is a cycle inside the graph, or the input is
    // invalid.
    // 2. return List<Node> as the result.
    public List<Integer> topologicalSort() {
        //Map<E, Integer> vst = new HashMap<>();
        int n = adj.length;
        int[] vst = new int[n];
        List<Integer> result = new ArrayList<>();
        for (int x = 0; x < n; x++) {
            if (!topologicalSort(x, vst, result)) {
                return null;
            }
        }
        Collections.reverse(result);
        return result;
    }

    private boolean topologicalSort(int root, int[] vst, List<Integer> result) {
        if (vst[root] == TEMPORARY) { // found cycle
            return false;
        }
        if (vst[root] == PERMANENT) {
            return true;
        }
        vst[root] = TEMPORARY;
        for (int child : getChildren(root)) {
            if (!topologicalSort(child, vst, result)) {
                return false;
            }
        }
        result.add(root);
        vst[root] = PERMANENT;
        return true;
    }
}
