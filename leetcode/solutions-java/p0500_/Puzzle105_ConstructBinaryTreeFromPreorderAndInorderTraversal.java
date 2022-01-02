package p0500_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author half-dead
 */
public class Puzzle105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, inorder, 0, 0, preorder.length);
        }

        public TreeNode buildTree(int[] pre, int[] in, int preIndex, int inIndex, int len) {
            if (len == 0) {
                return null;
            }
            TreeNode root = new TreeNode(pre[preIndex]);
            if (len == 1) {
                return root;
            }
            int k = inIndex;
            while (in[k] != root.val) {
                k++;
            }
            int leftNodesCount = k - inIndex;
            root.left = buildTree(pre, in, preIndex + 1, inIndex, leftNodesCount);
            root.right = buildTree(pre, in, preIndex + 1 + leftNodesCount, inIndex + 1 + leftNodesCount, len - 1 - leftNodesCount);
            return root;
        }
    }
}
