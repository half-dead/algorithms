package p1500_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/delete-leaves-with-a-given-value/
 *
 * @author half-dead
 */
public class Puzzle1325 {
    class Solution {
        public TreeNode removeLeafNodes(TreeNode root, int target) {
            if (root == null) return null;
            root.left = removeLeafNodes(root.left, target);
            root.right = removeLeafNodes(root.right, target);
            return (root.left == root.right && root.val == target) ? null : root;
        }
    }
}
