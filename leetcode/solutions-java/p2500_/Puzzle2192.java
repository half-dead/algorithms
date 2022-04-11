package p2500_;

import java.util.*;

/**
 * https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/
 *
 * @author half-dead
 */
public class Puzzle2192 {

    class Solution {
        public List<List<Integer>> getAncestors(int n, int[][] edges) {
            List<List<Integer>> g = new ArrayList<>(n);
            List<Set<Integer>> ancestors = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                g.add(new ArrayList<>());
                ancestors.add(new HashSet<>());
            }

            int[] indegrees = new int[n];
            for (int[] e : edges) {
                indegrees[e[0]]++;
                g.get(e[1]).add(e[0]);
            }

            LinkedList<Integer> q = new LinkedList<>();
            boolean[] v = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (indegrees[i] > 0) continue;
                dfs(g, i, v, ancestors, q);
            }

            List<List<Integer>> res = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                Set<Integer> ts = ancestors.get(i);
                if (ts == null) {
                    res.add(new ArrayList<>());
                } else {
                    ArrayList<Integer> al = new ArrayList<>(ts);
                    Collections.sort(al);
                    res.add(al);
                }
            }
            return res;
        }

        void dfs(List<List<Integer>> g, int i, boolean[] v,
                 List<Set<Integer>> ancestors, LinkedList<Integer> q) {
            for (int p : q) {
                ancestors.get(p).add(i);
            }
            if (v[i]) {
                for (int p : q) {
                    ancestors.get(p).addAll(ancestors.get(i));
                }
                return;
            }
            v[i] = true;

            q.addLast(i);
            for (int next : g.get(i)) {
                dfs(g, next, v, ancestors, q);
            }
            q.pollLast();
        }
    }

    class Solution0 {
        public List<List<Integer>> getAncestors(int n, int[][] edges) {
            List<List<Integer>> res = new ArrayList<>(), g = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                res.add(new ArrayList<>());
                g.add(new ArrayList<>());
            }
            for (int[] e : edges) g.get(e[0]).add(e[1]);
            for (int i = 0; i < n; i++) dfs(i, i, res, g);
            return res;
        }

        void dfs(int root, int i, List<List<Integer>> res, List<List<Integer>> g) {
            for (int c : g.get(i)) {
                List<Integer> temp = res.get(c);
                if (temp.size() == 0 || temp.get(temp.size() - 1) != root) {
                    temp.add(root);
                    dfs(root, c, res, g);
                }
            }
        }
    }

}
