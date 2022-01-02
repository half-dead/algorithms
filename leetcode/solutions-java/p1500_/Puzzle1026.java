package p1500_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 *
 * @author half-dead
 */
public class Puzzle1026 {
    // Top-Down
    class Solution {
        public int maxAncestorDiff(TreeNode root) {
            return dfs(root, root.val, root.val);
        }
        public int dfs(TreeNode node, int min, int max) {
            if (node == null) return max - min;
            min = Math.min(min, node.val);
            max = Math.max(max, node.val);
            return Math.max(dfs(node.left, min, max), dfs(node.right, min, max));
        }
    }

    // Bottom-Up
    class TopDownDfsSolution {
        public int maxAncestorDiff(TreeNode root) {
            int[] res = new int[1];
            dfs(root, res);
            return res[0];
        }

        public int[] dfs(TreeNode node, int[] res) {
            if (node == null) return null;

            int[] left = dfs(node.left, res), right = dfs(node.right, res);
            int min = node.val, max = node.val;
            if (left != null) {
                min = Math.min(min, left[0]);
                max = Math.max(max, left[1]);
                res[0] = Math.max(res[0], Math.max(Math.abs(node.val - left[0]), Math.abs(node.val - left[1])));
            }
            if (right != null) {
                min = Math.min(min, right[0]);
                max = Math.max(max, right[1]);
                res[0] = Math.max(res[0], Math.max(Math.abs(node.val - right[0]), Math.abs(node.val - right[1])));
            }
            return new int[]{min, max};
        }
    }
}
