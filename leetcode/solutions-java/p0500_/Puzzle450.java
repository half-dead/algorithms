package p0500_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 *
 * @author half-dead
 */
public class Puzzle450 {

    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;

            if (root.val == key) {
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;

                root.val = searchMax(root.left);
                root.left = deleteNode(root.left, root.val);
            } else {
                if (key < root.val) root.left = deleteNode(root.left, key);
                else root.right = deleteNode(root.right, key);
            }
            return root;
        }

        public int searchMax(TreeNode root) {
            while (root.right != null) root = root.right;
            return root.val;
        }
    }
}
