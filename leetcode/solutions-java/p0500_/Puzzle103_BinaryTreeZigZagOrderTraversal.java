/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

Given a binary tree, return the zigzag level order traversal of its nodes' values.
(ie, from left to right, then right to left for the next level and alternate between).

For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its zigzag level order traversal as:
    [
      [3],
      [20,9],
      [15,7]
    ]
 */

package p0500_;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author half-dead
 */
public class Puzzle103_BinaryTreeZigZagOrderTraversal {

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                LinkedList<TreeNode> temp = stack;
                LinkedList<TreeNode> next = new LinkedList<>();
                List<Integer> subList = new ArrayList<>();
                while (!temp.isEmpty()) {
                    TreeNode node = temp.pop();
                    subList.add(node.val);
                    if (node.left != null) {
                        next.addLast(node.left);
                    }
                    if (node.right != null) {
                        next.addLast(node.right);
                    }
                }
                result.add(subList);
                stack = next;
            }
            for (int i = 1; i < result.size(); i += 2) {
                Collections.reverse(result.get(i));
            }
            return result;
        }
    }
}
