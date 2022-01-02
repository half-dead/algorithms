package p0500_;

// Given a binary tree, find its maximum depth.
// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

import struct.TreeNode;

import java.util.ArrayDeque;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class Puzzle104_MaximumDepthOfBinaryTree {
    public class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int depth = 0;
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.peek();
                    if (node.left != null) queue.addLast(node.left);
                    if (node.right != null) queue.addLast(node.right);
                    queue.pop();
                }
                depth++;
            }
            return depth;
        }
    }

    public class RecursiveSolution {
        public int maxDepth(TreeNode root) {
            return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
