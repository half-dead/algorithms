package p1000_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 *
 * @author half-dead
 */
public class Puzzle783_MinimumDistanceBetweenBSTNodes {
    class Solution {
        public int minDiffInBST(TreeNode root) {
            int diff = Integer.MAX_VALUE;
            if (root == null) {
                return diff;
            }
            if (root.left != null) {
                TreeNode node = root.left;
                while (node.right != null) {
                    node = node.right;
                }
                diff = Math.min(diff, root.val - node.val);
                diff = Math.min(diff, minDiffInBST(root.left));
            }
            if (root.right != null) {
                TreeNode node = root.right;
                while (node.left != null) {
                    node = node.left;
                }
                diff = Math.min(diff, node.val - root.val);
                diff = Math.min(diff, minDiffInBST(root.right));
            }
            return diff;
        }
    }
}
