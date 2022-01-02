package p1000_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/univalued-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle965_UnivaluedBinaryTree {
    class Solution {
        public boolean isUnivalTree(TreeNode root) {
            return root != null
                    && (root.left == null || (root.val == root.left.val && isUnivalTree(root.left)))
                    && (root.right == null || (root.val == root.right.val && isUnivalTree(root.right)));
        }
    }
}
