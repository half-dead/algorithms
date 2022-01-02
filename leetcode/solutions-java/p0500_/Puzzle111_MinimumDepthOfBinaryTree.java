package p0500_;

// Given a binary tree, find its minimum depth.
//
// The minimum depth is the number of nodes along the shortest path
// from the root node down to the nearest leaf node.

import struct.TreeNode;

import java.util.ArrayDeque;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class Puzzle111_MinimumDepthOfBinaryTree {
    public class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int minDepth = 1;
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            if (root.left != null) queue.addLast(root.left);
            if (root.right != null) queue.addLast(root.right);
            while (!queue.isEmpty()) {
                minDepth++;
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.peek();
                    if (node.left == null && node.right == null) {
                        return minDepth;
                    } else {
                        if (node.left != null) queue.addLast(node.left);
                        if (node.right != null) queue.addLast(node.right);
                        queue.pop();
                    }
                }
            }
            return minDepth;
        }
    }

    public class RecursiveSolution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int minDepth;
            if (root.left == null) {
                minDepth = minDepth(root.right);
            } else if (root.right == null) {
                minDepth = minDepth(root.left);
            } else {
                minDepth = Math.min(minDepth(root.left), minDepth(root.right));
            }
            return 1 + minDepth;
        }
    }
}
