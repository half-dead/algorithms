package p1500_;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 *
 * @author half-dead
 */
public class Puzzle1110 {
    class Solution1 {
        public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
            Set<Integer> vals = new HashSet<>();
            for (int v : toDelete) vals.add(v);

            Set<TreeNode> nodes = new HashSet<>();
            nodes.add(root);
            dfs(vals, nodes, root);
            return new ArrayList<>(nodes);
        }

        private void dfs(Set<Integer> vals, Set<TreeNode> nodes, TreeNode node) {
            if (node == null) return;

            TreeNode left = node.left, right = node.right;
            if (vals.contains(node.val)) {
                nodes.remove(node);
                if (left != null) nodes.add(left);
                if (right != null) nodes.add(right);
            }
            if (left != null && vals.contains(left.val)) node.left = null;
            if (right != null && vals.contains(right.val)) node.right = null;
            dfs(vals, nodes, left);
            dfs(vals, nodes, right);
        }
    }

    class Solution {
        public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
            Set<Integer> vals = new HashSet<>();
            for (int v : toDelete) vals.add(v);

            Set<TreeNode> nodes = new HashSet<>();
            nodes.add(root);
            dfs(vals, nodes, root);
            return new ArrayList<>(nodes);
        }

        private TreeNode dfs(Set<Integer> vals, Set<TreeNode> nodes, TreeNode node) {
            if (node == null) return node;

            TreeNode left = node.left, right = node.right;
            boolean deleted = false;
            if (vals.contains(node.val)) {
                nodes.remove(node);
                deleted = true;
                if (left != null) nodes.add(left);
                if (right != null) nodes.add(right);
            }
            node.left = dfs(vals, nodes, left);
            node.right = dfs(vals, nodes, right);
            return deleted ? null : node;
        }
    }
}
