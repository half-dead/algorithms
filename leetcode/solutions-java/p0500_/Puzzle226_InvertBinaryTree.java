package p0500_;

// Invert a binary tree.
//
//      4
//    /   \
//   2     7
//  / \   / \
// 1   3 6   9
//
// to
//
//      4
//    /   \
//   7     2
//  / \   / \
// 9   6 3   1
//
// Trivia:
// This problem was inspired by this original tweet by Max Howell:
// Google: 90% of our engineers use the software you wrote (Homebrew),
// but you can’t invert a binary tree on a whiteboard so fuck off.


import struct.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class Puzzle226_InvertBinaryTree {
    public static void main(String[] args) {

        Puzzle226_InvertBinaryTree p = new Puzzle226_InvertBinaryTree();
        Solution s = p.new Solution();
        s.invertTree(new TreeNode("[]"));
    }

    // Recursive Solution
    public class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return root;

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }

    // Non-recursive Solution
    public class Solution2 {
        public TreeNode invertTree(TreeNode root) {
            LinkedList<TreeNode> list = new LinkedList<>();
            list.push(root);
            while (!list.isEmpty()) {
                TreeNode node = list.pop();
                if (node != null) {
                    if (node.left != null || node.right != null) {
                        TreeNode temp = node.left;
                        node.left = node.right;
                        node.right = temp;

                        if (node.left != null) {
                            list.push(node.left);
                        }

                        if (node.right != null) {
                            list.push(node.right);
                        }
                    }
                }

            }
            return root;
        }
    }
}
