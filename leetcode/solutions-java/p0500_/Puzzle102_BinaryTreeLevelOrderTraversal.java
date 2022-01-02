package p0500_;

// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
// For example:
// Given binary tree {3,9,20,#,#,15,7},
//          3
//         / \
//        9  20
//          /  \
//         15   7
// return its level order traversal as:
//        [
//         [3],
//         [9,20],
//         [15,7]
//       ]

import struct.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class Puzzle102_BinaryTreeLevelOrderTraversal {

    // for every level, use a different queue.
    public class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            result.add(Arrays.asList(root.val));
            LinkedList<TreeNode> oneLevel = new LinkedList<>();
            if (root.left != null) oneLevel.add(root.left);
            if (root.right != null) oneLevel.add(root.right);
            while (oneLevel.size() > 0) {
                LinkedList<TreeNode> nextLevel = new LinkedList<>();
                List<Integer> valList = new ArrayList<>();
                for (TreeNode treeNode : oneLevel) {
                    valList.add(treeNode.val);
                    if (treeNode.left != null) nextLevel.add(treeNode.left);
                    if (treeNode.right != null) nextLevel.add(treeNode.right);
                }
                result.add(valList);
                oneLevel = nextLevel;
            }
            return result;
        }
    }

    // use only one queue for all levels
    public class Solution2 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                int currLevelSize = queue.size();
                List<Integer> valList = new ArrayList<>(currLevelSize);
                for (int i = 0; i < currLevelSize; i++) {
                    TreeNode tn = queue.peek();
                    if (tn.left != null) queue.addLast(tn.left);
                    if (tn.right != null) queue.addLast(tn.right);
                    valList.add(queue.pop().val);
                }
                result.add(valList);
            }
            return result;
        }
    }
}
