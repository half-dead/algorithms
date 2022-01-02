/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as
 the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6.
Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.


 */

package p0500_;

import struct.TreeNode;

/**
 * @author half-dead
 */
public class Puzzle235_LowestCommonAncestorOfABinarySearchTree {

    public static void main(String[] args) {
        Puzzle235_LowestCommonAncestorOfABinarySearchTree p = new Puzzle235_LowestCommonAncestorOfABinarySearchTree();
        Solution solution = p.new Solution();
        TreeNode root = new TreeNode("[4,2,6,1,3,5,7]");
        System.out.println(solution.lowestCommonAncestor(root, root.left.right, root.right.left));
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            int min = Math.min(p.val, q.val);
            int max = Math.max(p.val, q.val);

            while (max <= root.val || min >= root.val) {
                if (max == root.val) {
                    return p.val == max ? p : q;
                } else if (min == root.val) {
                    return p.val == min ? p : q;
                }

                if (max < root.val) {
                    root = root.left;
                } else if (min > root.val) {
                    root = root.right;
                }
            }
            return root;
        }
    }


}
