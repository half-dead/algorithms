package p1500_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle1339 {

    class Solution {
        public int maxProduct(TreeNode root) {
            long[] res = new long[1];
            dfs(root, sum(root), res);
            return (int) (res[0] % 1000000007);
        }

        int sum(TreeNode node) {
            return node == null ? 0 : node.val + sum(node.left) + sum(node.right);
        }

        long dfs(TreeNode node, int total, long[] res) {
            if (node == null) return 0;
            long left = dfs(node.left, total, res), right = dfs(node.right, total, res);
            res[0] = Math.max(res[0], Math.max(left * (total - left), right * (total - right)));
            return node.val + left + right;
        }
    }
}
