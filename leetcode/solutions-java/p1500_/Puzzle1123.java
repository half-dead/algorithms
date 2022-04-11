package p1500_;

import struct.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 *
 * @author half-dead
 */
public class Puzzle1123 {

    class Solution {
        int max = 0;
        TreeNode lca;

        public TreeNode lcaDeepestLeaves(TreeNode root) {
            maxLeafDepth(root, 0);
            return lca;
        }

        private int maxLeafDepth(TreeNode node, int depth) {
            max = Math.max(max, depth);
            if (node == null) return depth;

            int left = maxLeafDepth(node.left, depth + 1), right = maxLeafDepth(node.right, depth + 1);
            if (left == max && right == max) {
                lca = node;
            }
            return Math.max(left, right);
        }
    }

    class Solution1 {
        int max = 0;
        LinkedList<TreeNode> cache = new LinkedList<>(), copy;

        public TreeNode lcaDeepestLeaves(TreeNode root) {
            cache.addLast(root);

            dfs(root, 0, new LinkedList<>());
            return cache.peekLast();
        }

        void dfs(TreeNode root, int depth, LinkedList<TreeNode> q) {
            if (root == null) return;

            q.addLast(root);
            if (root.left == null && root.right == null) {
                if (depth == max) {
                    copy = new LinkedList<>(q);
                    while (copy.size() > cache.size()) copy.pollLast();
                    while (copy.size() > 0 && copy.peekLast() != cache.peekLast()) {
                        copy.pollLast();
                        cache.pollLast();
                    }
                } else if (depth > max) {
                    cache = new LinkedList<>(q);
                }
                max = Math.max(max, depth);
            } else {
                dfs(root.left, depth + 1, q);
                dfs(root.right, depth + 1, q);
            }
            q.pollLast();
        }
    }

}
