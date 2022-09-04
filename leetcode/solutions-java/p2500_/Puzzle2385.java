package p2500_;

import struct.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
 *
 * @author half-dead
 */
public class Puzzle2385 {

    class Solution {

        Map<Integer, Set<Integer>> g = new HashMap<>();

        public int amountOfTime(TreeNode root, int start) {
            dfs(root);
            Deque<Integer> q = new LinkedList<>();
            q.offerLast(start);

            boolean[] v = new boolean[100001];
            v[start] = true;

            int d = 0;
            while (q.size() > 0) {
                int size = q.size();
                while (size-- > 0) {
                    int node = q.pollFirst();

                    Set<Integer> set = g.get(node);
                    if (set == null) continue;

                    for (int next : set) {
                        if (v[next]) continue;
                        v[next] = true;
                        q.offerLast(next);
                    }
                }
                d++;
            }
            return d - 1;
        }

        void dfs(TreeNode node) {
            if (node == null) return;

            int v = node.val;
            if (node.left != null) {
                int lv = node.left.val;
                g.computeIfAbsent(v, x -> new HashSet<>()).add(lv);
                g.computeIfAbsent(lv, x -> new HashSet<>()).add(v);
                dfs(node.left);
            }

            if (node.right != null) {
                int rv = node.right.val;
                g.computeIfAbsent(v, x -> new HashSet<>()).add(rv);
                g.computeIfAbsent(rv, x -> new HashSet<>()).add(v);
                dfs(node.right);
            }
        }
    }
}
