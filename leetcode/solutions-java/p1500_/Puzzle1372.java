package p1500_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle1372 {


    class Solution {
        public int longestZigZag(TreeNode root) {
            int[] res = dfs(root);
            return Math.max(res[0], Math.max(res[1], res[2]));
        }

        int[] dfs(TreeNode node) {
            if (node == null) return new int[]{0, 0, 0};
            int[] left = dfs(node.left), right = dfs(node.right);
            return new int[]{
                    node.left != null ? 1 + left[1] : 0,
                    node.right != null ? 1 + right[0] : 0,
                    Math.max(Math.max(left[0], left[2]), Math.max(right[1], right[2]))
            };
        }
    }

    // same idea, but shorter and simpler
    class Solution0 {
        public int longestZigZag(TreeNode root) {
            return dfs(root)[2];
        }

        private int[] dfs(TreeNode root) {
            if (root == null) return new int[]{-1, -1, -1};
            int[] left = dfs(root.left), right = dfs(root.right);
            int res = Math.max(Math.max(left[1], right[0]) + 1, Math.max(left[2], right[2]));
            return new int[]{left[1] + 1, right[0] + 1, res};
        }
    }
}
