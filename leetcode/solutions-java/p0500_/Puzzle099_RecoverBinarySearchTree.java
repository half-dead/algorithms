package p0500_;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 *
 * @author half-dead
 */
public class Puzzle099_RecoverBinarySearchTree {

    class Solution {
        TreeNode n1, n2;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        public void recoverTree(TreeNode root) {
            inorder(root);
            int temp = n1.val;
            n1.val = n2.val;
            n2.val = temp;
        }

        void inorder(TreeNode root) {
            if (root == null) return;
            inorder(root.left);
            if (prev.val > root.val) {
                if (n1 == null) n1 = prev;
                n2 = root;
            }
            prev = root;
            inorder(root.right);
        }
    }

    // O(n) Space inorder solution
    class Solution2 {
        public void recoverTree(TreeNode root) {
            if (root == null) return;
            List<TreeNode> list = new ArrayList<>();
            inorder(root, list);

            int idx1 = -1, idx2 = -1;
            for (int i = 0; i < list.size() - 1; i++) {
                TreeNode n1 = list.get(i), n2 = list.get(i + 1);
                if (n1.val > n2.val) {
                    if (idx1 == -1) {
                        idx1 = i;
                    }
                    idx2 = i + 1;
                }
            }
            if (idx1 < 0 || idx2 < 0) throw new IllegalArgumentException();
            TreeNode n1 = list.get(idx1), n2 = list.get(idx2);
            int temp = n1.val;
            n1.val = n2.val;
            n2.val = temp;
        }

        void inorder(TreeNode root, List<TreeNode> list) {
            if (root != null) {
                inorder(root.left, list);
                list.add(root);
                inorder(root.right, list);
            }
        }
    }
}
