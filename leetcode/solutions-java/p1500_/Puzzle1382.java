package p1500_;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/balance-a-binary-search-tree/
 *
 * @author half-dead
 */
public class Puzzle1382 {
    class Solution {
        public TreeNode balanceBST(TreeNode root) {
            ArrayList<TreeNode> list = new ArrayList<>();
            inorder(root, list);
            return balance(list, 0, list.size() - 1);
        }

        TreeNode balance(List<TreeNode> list, int from, int to) {
            if (from > to) return null;

            int mid = (from + to) / 2;
            TreeNode parent = list.get(mid);
            parent.left = balance(list, from, mid - 1);
            parent.right = balance(list, mid + 1, to);
            return parent;
        }

        void inorder(TreeNode node, List<TreeNode> list) {
            if (node == null) return;
            inorder(node.left, list);
            list.add(node);
            inorder(node.right, list);
        }
    }
}
