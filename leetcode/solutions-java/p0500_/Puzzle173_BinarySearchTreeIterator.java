package p0500_;

import struct.TreeNode;

import java.util.ArrayDeque;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 *
 * @author half-dead
 */
public class Puzzle173_BinarySearchTreeIterator {

    class BSTIterator {
        private TreeNode root;
        private ArrayDeque<TreeNode> q = new ArrayDeque<>();

        public BSTIterator(TreeNode node) {
            this.root = node;
            while (node != null) {
                q.push(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode top = q.peek();
            if (top.right != null) {
                q.pop();
                TreeNode node = top.right;
                while (node != null) {
                    q.push(node);
                    node = node.left;
                }
                return top.val;
            } else {
                return q.pop().val;
            }
        }

        public boolean hasNext() {
            return q.size() > 0;
        }
    }
}
