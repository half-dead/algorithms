package p1500_;

import struct.TreeNode;

/**
 * Sum of Root To Leaf Binary Numbers
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 *
 * @author half-dead
 */
public class Puzzle1022 {
    class Solution {
        public int sumRootToLeaf(TreeNode root) {
            return dfs(root, 0);
        }

        public int dfs(TreeNode node, int n) {
            if (node == null) return 0;
            n = (n << 1) + node.val;
            return (node.left == null && node.right == null) ? n : (dfs(node.left, n) + dfs(node.right, n));
        }
    }
}
