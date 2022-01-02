package p0500_;

// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
// For example, this binary tree is symmetric:
//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
// But the following is not:
//    1
//   / \
//  2   2
//   \   \
//   3    3
//
// Note:
// Bonus points if you could solve it both recursively and iteratively.
//

import struct.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
public class Puzzle101_SymmetricTree {

    public class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            LinkedList<TreeNode> ltree = new LinkedList<>();
            LinkedList<TreeNode> rtree = new LinkedList<>();
            if (root.left != null) ltree.push(root.left);
            if (root.right != null) rtree.push(root.right);
            while (ltree.size() > 0 && rtree.size() > 0) {
                TreeNode left = ltree.pop();
                TreeNode right = rtree.pop();
                if (left.val != right.val) return false;
                boolean ll = left.left != null, rr = right.right != null;
                boolean lr = left.right != null, rl = right.left != null;
                if (left.val != right.val || (ll ^ rr) || (lr ^ rl)) {
                    return false;
                } else {
                    if (ll) ltree.push(left.left);
                    if (rr) rtree.push(right.right);
                    if (lr) ltree.push(left.right);
                    if (rl) rtree.push(right.left);
                }
            }
            return ltree.size() == rtree.size();
        }
    }

    public class RecursiveSolution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return subSymmetric(root.left, root.right);
        }

        public boolean subSymmetric(TreeNode left, TreeNode right) {
            if (left != null && right != null && left.val == right.val) {
                return subSymmetric(left.left, right.right) && subSymmetric(left.right, right.left);
            }
            if (left == null && right == null) {
                return true;
            }
            return false;
        }
    }
}
