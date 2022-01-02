package p1000_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 *
 * @author half-dead
 */
public class Puzzle701_InsertIntoABinarySearchTree {
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (val < root.val) {
                if (root.left == null) {
                    root.left = new TreeNode(val);
                } else {
                    insertIntoBST(root.left, val);
                }
            } else {
                if (root.right == null) {
                    root.right = new TreeNode(val);
                } else {
                    insertIntoBST(root.right, val);
                }
            }
            return root;
        }
    }

    class Solution2 {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            TreeNode temp = root;
            TreeNode temp1 = null;
            while (temp != null) {
                if (temp.val > val) {
                    temp1 = temp;
                    temp = temp.left;
                } else {
                    temp1 = temp;
                    temp = temp.right;
                }
            }
            if (val < temp1.val)
                temp1.left = new TreeNode(val);
            else
                temp1.right = new TreeNode(val);
            return root;

        }
    }

    class Solution3 {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (val < root.val) {
                root.left = insertIntoBST(root.left, val);
            } else {
                root.right = insertIntoBST(root.right, val);
            }
            return root;
        }
    }
}
