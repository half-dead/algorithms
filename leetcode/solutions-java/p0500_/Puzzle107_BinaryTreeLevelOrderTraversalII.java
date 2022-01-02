package p0500_;

// Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
// For example:
// Given binary tree {3,9,20,#,#,15,7},
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its bottom-up level order traversal as:
// [
//   [15,7],
//   [9,20],
//   [3]
// ]

import struct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class Puzzle107_BinaryTreeLevelOrderTraversalII {

    // use only one queue for all levels
    public class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            LinkedList<List<Integer>> result = new LinkedList<>();
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
                result.addFirst(valList);
            }
            return result;
        }
    }
}
