package p1000_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle979_DistributeCoinsInBinaryTree {

    public static void main(String[] args) {
        Puzzle979_DistributeCoinsInBinaryTree p = new Puzzle979_DistributeCoinsInBinaryTree();
        Solution s1 = p.new Solution();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(0);
        System.out.println(s1.distributeCoins(root));
    }

    class Solution {
        private int ans = 0;

        public int distributeCoins(TreeNode root) {
            dfs(root);
            return ans;
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = dfs(node.left);
            int right = dfs(node.right);
            ans += Math.abs(left) + Math.abs(right);
            return node.val + left + right - 1;
        }
    }

}
