package p0500_;

// Given a binary tree, return the preorder traversal of its nodes' values.
//
// For example:
// Given binary tree {1,#,2,3},
// 1
//  \
//   2
//  /
// 3
// return [1,2,3].
//
// Note: Recursive solution is trivial, could you do it iteratively?

import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class Puzzle144_BinaryTreePreorderTraversal {

    public class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            LinkedList<TreeNode> right = new LinkedList<>();
            while (root != null) {
                result.add(root.val);
                if (root.right != null) {
                    right.addFirst(root.right);
                }
                root = root.left;
                if (root == null && !right.isEmpty()) {
                    root = right.removeFirst();
                }
            }
            return result;
        }
    }

    public class RecursiveSolution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            recurse(result, root);
            return result;
        }

        public void recurse(List<Integer> list, TreeNode node) {
            if (node == null) return;
            list.add(node.val);
            recurse(list, node.left);
            recurse(list, node.right);
        }
    }
}
