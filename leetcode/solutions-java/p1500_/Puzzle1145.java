package p1500_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-coloring-game/
 *
 * @author half-dead
 */
public class Puzzle1145 {

    class Solution {
        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            int[] cnt = new int[2];
            count(root, x, cnt);
            return Math.max(Math.max(cnt[0], cnt[1]), n - cnt[0] - cnt[1] - 1) > (n >> 1);
        }

        int count(TreeNode node, int x, int[] cnt) {
            if (node == null) return 0;
            int left = count(node.left, x, cnt), right = count(node.right, x, cnt);
            if (node.val == x) {
                cnt[0] = left;
                cnt[1] = right;
            }
            return 1 + left + right;
        }
    }

    // two recursive calls, one to find the node, one to count its left and right children count
    class Solution1 {
        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            TreeNode fp = find(root, x);
            int c1 = count(fp.left), c2 = count(fp.right), c3 = n - c1 - c2 - 1;
            return c1 > n - c1 || c2 > n - c2 || c3 > n - c3;
        }

        int count(TreeNode node) {
            if (node == null) return 0;
            return 1 + count(node.left) + count(node.right);
        }

        TreeNode find(TreeNode node, int x) {
            if (node == null) return null;
            if (node.val == x) return node;
            TreeNode next = find(node.left, x);
            return next != null ? next : find(node.right, x);
        }
    }
}
