package p1000_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle671 {

    class Solution {
        public int findSecondMinimumValue(TreeNode root) {
            if (root == null) return -1;
            return dfs(root, root.val);
        }

        public int dfs(TreeNode root, int val) {
            if (root == null) return -1;
            if (root.val > val) return root.val;
            if (root.left == null) return -1;
            int left = dfs(root.left, val);
            int right = dfs(root.right, val);
            if (left == -1 || right == -1) return Math.max(left, right);
            else return Math.min(left, right);
        }
    }
}
