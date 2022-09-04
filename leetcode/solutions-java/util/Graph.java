package util;

import java.util.*;

/**
 * @author half-dead
 */ // Including topological sort.
// Tested by Leetcode 1203 and 1857
class Graph<E> {
    Map<E, List<E>> adj = new HashMap<>();
    List<E> emptyList = new ArrayList<>();

    // NOTE: remember to call addNode() to add single nodes
    public void addNode(E node) {
        adj.computeIfAbsent(node, k -> new ArrayList<>());
    }

    // directed edge x -> y
    public void link(E x, E y) {
        adj.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
    }

    public List<E> getChildren(E x) {
        return adj.getOrDefault(x, emptyList);
    }

    public Set<E> getAllNodes() {
        return adj.keySet();
    }

    private static final int TEMPORARY = 1;
    private static final int PERMANENT = 2;

    // x -> y means x should be processed before y
    // The input is a directed graph.
    // 1. return null, means there is a cycle inside the graph, or the input is
    // invalid.
    // 2. return List<Node> as the result.
    public List<E> topologicalSort() {
        Map<E, Integer> vst = new HashMap<>();
        List<E> result = new ArrayList<>();
        for (E x : getAllNodes()) {
            if (!topologicalSort(x, vst, result)) {
                return null;
            }
        }
        Collections.reverse(result);
        return result;
    }

    private boolean topologicalSort(E root, Map<E, Integer> vst, List<E> result) {
        if (vst.getOrDefault(root, 0) == TEMPORARY) { // found cycle
            return false;
        }

        if (vst.getOrDefault(root, 0) == PERMANENT) {
            return true;
        }
        vst.put(root, TEMPORARY);
        for (E child : getChildren(root)) {
            if (!topologicalSort(child, vst, result)) {
                return false;
            }
        }
        result.add(root);
        vst.put(root, PERMANENT);
        return true;
    }
}
