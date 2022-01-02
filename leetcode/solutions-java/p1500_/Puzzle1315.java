package p1500_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 *
 * @author half-dead
 */
public class Puzzle1315 {
    class Solution2 {
        public int sumEvenGrandparent(TreeNode root) {
            int[] res = new int[1];
            dfs(root, false, false, res);
            return res[0];
        }

        public void dfs(TreeNode node, boolean gp, boolean p, int[] res) {
            if (node == null) return;
            if (gp) res[0] += node.val;

            boolean b = node.val % 2 == 0;
            dfs(node.left, p, b, res);
            dfs(node.right, p, b, res);
        }
    }

    class Solution {
        public int sumEvenGrandparent(TreeNode root) {
            return dfs(root, false, false);
        }
        public int dfs(TreeNode node, boolean gp, boolean p) {
            return node == null ? 0 : ((gp ? node.val : 0) + dfs(node.left, p, node.val % 2 == 0) + dfs(node.right, p, node.val % 2 == 0));
        }
    }
}
