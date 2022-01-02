package p1000_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/complete-binary-tree-inserter/
 *
 * @author half-dead
 */
public class Puzzle919 {


    class CBTInserter {

        private int n;
        private TreeNode root;

        public CBTInserter(TreeNode node) {
            int[] cnt = new int[1];
            dfs(node, cnt);

            n = cnt[0];
            root = node;
        }

        private void dfs(TreeNode node, int[] cnt) {
            if (node == null) return;
            cnt[0]++;
            dfs(node.left, cnt);
            dfs(node.right, cnt);
        }

        public int insert(int v) {
            TreeNode node = new TreeNode(v);
            String bs = Integer.toBinaryString((n + 1) / 2);

            TreeNode curr = root;
            for (int i = 1; i < bs.length(); i++) {
                curr = bs.charAt(i) == '0' ? curr.left : curr.right;
            }

            if (++n % 2 == 0) {
                curr.left = node;
            } else {
                curr.right = node;
            }
            return curr.val;
        }

        public TreeNode get_root() {
            return root;
        }

    }

}
