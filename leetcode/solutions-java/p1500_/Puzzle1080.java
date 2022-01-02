package p1500_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/
 *
 * @author half-dead
 */
public class Puzzle1080 {
    class Solution {
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            if (root == null) return null;
            if (root.left == null && root.right == null) return root.val < limit ? null : root;
            limit -= root.val;
            root.left = sufficientSubset(root.left, limit);
            root.right = sufficientSubset(root.right, limit);
            return root.left == root.right ? null : root;
        }
    }

    class Solution2 {
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            return dfs(root, 0, limit) ? null : root;
        }

        boolean dfs(TreeNode node, int sum, int limit) {
            if (node == null) return sum < limit;

            sum += node.val;
            boolean b1 = dfs(node.left, sum, limit);
            if (b1) node.left = null;

            boolean b2 = dfs(node.right, sum, limit);
            if (b2) node.right = null;

            return (b1 && (b2 || node.right == null)) || (b2 && node.left == null);
        }
    }
}
