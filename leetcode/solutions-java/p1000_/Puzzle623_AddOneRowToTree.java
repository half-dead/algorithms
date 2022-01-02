package p1000_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/add-one-row-to-tree/
 *
 * @author half-dead
 */
public class Puzzle623_AddOneRowToTree {
    class Solution {
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            if (d == 1) {
                TreeNode node = new TreeNode(v);
                node.left = root;
                return node;
            } else if (root == null) {
                return null;
            } else if (d == 2) {
                TreeNode n1 = new TreeNode(v);
                TreeNode n2 = new TreeNode(v);
                n1.left = root.left;
                n2.right = root.right;
                root.left = n1;
                root.right = n2;
                return root;
            } else {
                d--;
                addOneRow(root.left, v, d);
                addOneRow(root.right, v, d);
                return root;
            }
        }
    }
}
