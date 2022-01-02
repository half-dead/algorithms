package p1000_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 *
 * @author half-dead
 */
public class Puzzle897_IncreasingOrderSearchTree {

    class Solution {
        public TreeNode increasingBST(TreeNode root) {
            return increasingBST(root, null);
        }

        TreeNode increasingBST(TreeNode root, TreeNode tail) {
            if (root == null) return tail;
            TreeNode res = increasingBST(root.left, root);
            root.left = null;
            root.right = increasingBST(root.right, tail);
            return res;
        }
    }

    class Solution2 {
        TreeNode cur;

        public TreeNode increasingBST(TreeNode root) {
            TreeNode ans = new TreeNode(0);
            cur = ans;
            inorder(root);
            return ans.right;
        }

        void inorder(TreeNode node) {
            if (node == null) return;
            inorder(node.left);
            node.left = null;
            cur.right = node;
            cur = node;
            inorder(node.right);
        }
    }
}
