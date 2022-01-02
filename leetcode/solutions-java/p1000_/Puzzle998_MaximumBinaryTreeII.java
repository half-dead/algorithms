package p1000_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/maximum-binary-tree-ii/
 *
 * @author half-dead
 */
public class Puzzle998_MaximumBinaryTreeII {
    class Solution {
        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);

            if (val > root.val) {
                TreeNode node = new TreeNode(val);
                node.left = root;
                return node;
            }

            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
    }
}
