package p0500_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * @author half-dead
 */
public class Puzzle106_ConstructBinaryTreeFromInorderAndPostOrderTraversal {
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return buildTree(inorder, postorder, 0, 0, inorder.length);
        }

        private TreeNode buildTree(int[] in, int[] post, int inIdx, int postIdx, int len) {
            if (len == 0) {
                return null;
            }
            TreeNode root = new TreeNode(post[postIdx + len - 1]);
            if (len == 1) {
                return root;
            }
            int k = inIdx;
            while (in[k] != root.val) {
                k++;
            }
            int leftNodesCount = k - inIdx;
            root.left = buildTree(in, post, inIdx, postIdx, leftNodesCount);
            root.right = buildTree(in, post, inIdx + leftNodesCount + 1, postIdx + leftNodesCount, len - leftNodesCount - 1);
            return root;
        }
    }
}
