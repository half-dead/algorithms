/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 */

package p0500_;

import struct.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author half-dead
 */
public class Puzzle236_LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {
        Puzzle236_LowestCommonAncestorOfABinaryTree p = new Puzzle236_LowestCommonAncestorOfABinaryTree();
        Solution solution = p.new Solution();
        TreeNode root = new TreeNode("[1,2,3,4,5,6,7]");
        System.out.println(solution.lowestCommonAncestor(root, root.left.right, root.right.left));
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return parentOfEither(root, p, q);
        }

        public TreeNode parentOfEither(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode lParent = parentOfEither(root.left, p, q);
            TreeNode rParent = parentOfEither(root.right, p, q);
            if (lParent != null && rParent != null) {
                return root;
            }
            return lParent != null ? lParent : rParent;
        }
    }

    class PathSolution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            LinkedList<TreeNode> pathp = new LinkedList<>();
            findPath(root, p, pathp);
            LinkedList<TreeNode> pathq = new LinkedList<>();
            findPath(root, q, pathq);

            Iterator<TreeNode> pi = pathp.iterator();
            Iterator<TreeNode> qi = pathq.iterator();

            TreeNode result = null;
            while (pi.hasNext() && qi.hasNext()) {
                TreeNode p1 = pi.next();
                TreeNode p2 = qi.next();
                if (p1 == p2) {
                    result = p1;
                } else {
                    break;
                }
            }
            return result;
        }

        public boolean findPath(TreeNode parent, TreeNode leaf, LinkedList<TreeNode> path) {
            path.add(parent);
            if (parent == leaf) {
                return true;
            }

            if (parent.left != null) {
                if (findPath(parent.left, leaf, path)) {
                    return true;
                } else {
                    path.removeLast();
                }
            }

            if (parent.right != null) {
                if (findPath(parent.right, leaf, path)) {
                    return true;
                } else {
                    path.removeLast();
                }
            }

            return false;
        }

    }
}
