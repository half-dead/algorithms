package p0500_;

// Given a binary tree, determine if it is height-balanced.
//
// For this problem, a height-balanced binary tree is defined as a binary tree
// in which the depth of the two subtrees of every node never differ by more than 1.

import struct.TreeNode;

import java.util.ArrayDeque;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class Puzzle110_BalancedBinaryTree {
    public static void main(String[] args) {
        Puzzle110_BalancedBinaryTree p = new Puzzle110_BalancedBinaryTree();
        RecursiveSolution solution = new RecursiveSolution();

        TreeNode root = new TreeNode("{1,2,2,3,3,3,3,4,4,4,4,4,4,#,#,5,5,5,5,5,#,5,#,#,#,#,#,#,#,#,#,6}");

        boolean balanced = solution.isBalanced(root);
        System.out.println(balanced);
    }

    // O(n) dfs solution
    public class BetterSolution {
        public boolean isBalanced(TreeNode root) {
            return dfsHeight(root) != -1;
        }

        public int dfsHeight(TreeNode root) {
            if (root == null) return 0;
            int l = dfsHeight(root.left);
            if (l == -1) {
                return -1;
            }
            int r = dfsHeight(root.right);
            if (r == -1) {
                return -1;
            }
            if (Math.abs(l - r) > 1) {
                return -1;
            }
            return 1 + Math.max(l, r);
        }
    }

    public static class RecursiveSolution {

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            int i = Math.abs(maxDepth(root.left) - maxDepth(root.right));
            if (i > 1) {
                return false;
            } else {
                return isBalanced(root.left) && isBalanced(root.right);
            }
        }

        public int maxDepth(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int depth = 1;
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode peek = queue.peek();
                    if (peek.left != null) queue.addLast(peek.left);
                    if (peek.right != null) queue.addLast(peek.right);
                    queue.pop();
                }
                depth++;
            }
            return depth;
        }
    }
}
