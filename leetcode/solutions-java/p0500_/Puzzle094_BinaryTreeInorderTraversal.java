package p0500_;

// Given a binary tree, return the inorder traversal of its nodes' values.
//
// For example:
// Given binary tree {1,#,2,3},
// 1
//  \
//   2
//  /
// 3
// return [1,3,2].
//
// Note: Recursive solution is trivial, could you do it iteratively?

import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class Puzzle094_BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        Puzzle094_BinaryTreeInorderTraversal p = new Puzzle094_BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode("{1,2,3,4,5,6,7}");

        Solution solution = p.new Solution();

        List<Integer> integers = solution.inorderTraversal(root);
        System.out.println(integers);
    }

    public class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            LinkedList<TreeNode> toVisit = new LinkedList<>();
            while (root != null || !toVisit.isEmpty()) {
                if (root != null) {
                    toVisit.addLast(root);
                    root = root.left;
                } else {
                    TreeNode node = toVisit.removeLast();
                    result.add(node.val);
                    root = node.right;
                }
            }
            return result;
        }
    }

    public class RecursiveSolution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            recurse(list, root);
            return list;
        }

        public void recurse(List<Integer> list, TreeNode node) {
            if (node == null) return;
            recurse(list, node.left);
            list.add(node.val);
            recurse(list, node.right);
        }
    }
}
