package p1000_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-cameras/
 *
 * @author half-dead
 */
public class Puzzle968 {

    // top-down dp
    class Solution {
        public int minCameraCover(TreeNode root) {
            int[] res = dfs(root);
            return Math.min(res[0], res[1]);
        }

        // 0: monitored by self
        // 1: monitored by child
        // 2: not monitored
        int[] dfs(TreeNode node) {
            if (node == null) return new int[]{10000, 0, 0};

            int[] l = dfs(node.left), r = dfs(node.right);
            int l01 = Math.min(l[0], l[1]), ml = Math.min(l01, l[2]);
            int r01 = Math.min(r[0], r[1]), mr = Math.min(r01, r[2]);
            return new int[]{
                    1 + Math.min(l[2] + mr, r[2] + ml),
                    Math.min(l[0] + r01, r[0] + l01),
                    l[1] + r[1]
            };
        }
    }

    // greedy dfs
    class DfsSolution {
        private final int NOT_MONITORED = 0;
        private final int MONITORED_NOCAM = 1;
        private final int MONITORED_CAM = 2;
        private int cameras = 0;

        public int minCameraCover(TreeNode root) {
            int top = dfs(root);
            return cameras + (top == NOT_MONITORED ? 1 : 0);
        }

        private int dfs(TreeNode root) {
            if (root == null) return MONITORED_NOCAM;

            int left = dfs(root.left), right = dfs(root.right);
            if (left == MONITORED_NOCAM && right == MONITORED_NOCAM) {
                return NOT_MONITORED;
            } else if (left == NOT_MONITORED || right == NOT_MONITORED) {
                cameras++;
                return MONITORED_CAM;
            } else {
                return MONITORED_NOCAM;
            }
        }
    }
}
