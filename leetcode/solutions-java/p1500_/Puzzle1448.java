package p1500_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle1448 {
    class Solution {
        public int goodNodes(TreeNode root) {
            if (root == null) return 0;

            int[] res = new int[1];
            dfs(root, root.val, res);
            return res[0];
        }

        void dfs(TreeNode node, int max, int[] res) {
            if (node == null) return;
            if (node.val >= max) {
                res[0]++;
                max = node.val;
            }
            dfs(node.left, max, res);
            dfs(node.right, max, res);
        }
    }
}
