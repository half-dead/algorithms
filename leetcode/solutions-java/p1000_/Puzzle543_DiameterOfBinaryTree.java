package p1000_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle543_DiameterOfBinaryTree {
    class Solution {
        int[] x = new int[2];

        public int diameterOfBinaryTree(TreeNode root) {
            int[] d = dfs(root);
            return Math.max(0, Math.max(d[0], d[1]) - 1);
        }

        private int[] dfs(TreeNode node) {
            if (node == null) return x;
            int[] left = dfs(node.left), right = dfs(node.right);
            return new int[]{
                    1 + Math.max(left[0], right[0]), // max diameter ends at node
                    Math.max(Math.max(left[1], right[1]), 1 + left[0] + right[0]) // max diameter not ends at node
            };
        }
    }
}
