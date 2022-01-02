package p1000_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/cousins-in-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle993_CousinsInBinaryTree {
    public static void main(String[] args) {
        Puzzle993_CousinsInBinaryTree p = new Puzzle993_CousinsInBinaryTree();
        Solution s = p.new Solution();
        System.out.println(s.isCousins(new TreeNode("[1,2,3,4]"), 4, 3));
        System.out.println(s.isCousins(new TreeNode("[1,2,3,#,4,#,5]"), 5, 4));
        System.out.println(s.isCousins(new TreeNode("[1,2,3,#,4]"), 2, 3));
        System.out.println(s.isCousins(new TreeNode("[1,2,3,#,#,#,4,#,5]"), 3, 2));
    }

    class Solution {
        class Pair {
            TreeNode p;
            int level = -1;
        }

        public boolean isCousins(TreeNode root, int x, int y) {
            Pair p1 = new Pair(), p2 = new Pair();
            recur(root, x, 0, p1);
            recur(root, y, 0, p2);
            return p1.level > 0 && p1.level == p2.level && p1.p != p2.p;
        }

        void recur(TreeNode node, int x, int level, Pair p) {
            if (node == null) return;
            if (node.val == x) p.level = level + 1;

            if (p.level < 0) {
                p.p = node;
                recur(node.left, x, level + 1, p);
            }
            if (p.level < 0) {
                p.p = node;
                recur(node.right, x, level + 1, p);
            }
        }
    }

}
