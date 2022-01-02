package p0500_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 *
 * @author half-dead
 */
public class Puzzle222 {

    // O(logN * logN), Iterative
    class Solution {
        public int countNodes(TreeNode root) {
            int cnt = 0, h = height(root);
            while (root != null) {
                if (--h == height(root.right)) {
                    cnt += 1 << h;
                    root = root.right;
                } else {
                    cnt += 1 << (h - 1);
                    root = root.left;
                }
            }
            return cnt;
        }

        int height(TreeNode node) {
            return node == null ? 0 : 1 + height(node.left);
        }
    }

    // O(n)
    class DfsSolution {
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

    }
}
