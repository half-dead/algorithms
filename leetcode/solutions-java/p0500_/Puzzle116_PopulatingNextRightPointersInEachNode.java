/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
Example:

Given the following perfect binary tree,

     1
   /  \
  2    3
 / \  / \
4  5  6  7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL

 */

package p0500_;

import struct.TreeLinkNode;

/**
 * @author half-dead
 */
public class Puzzle116_PopulatingNextRightPointersInEachNode {


    public class Solution {
        public void connect(TreeLinkNode root) {
            if (root == null) {
                return;
            }
            recur(root.left, root.right);
        }

        public void recur(TreeLinkNode left, TreeLinkNode right) {
            if (left == null) {
                return;
            }
            left.next = right;
            if (left.left == null) {
                return;
            }
            left.right.next = right.left;
            recur(left.left, left.right);
            recur(left.right, right.left);
            recur(right.left, right.right);
        }
    }

    // Neat!!!
    public class IterativeSolution {
        public void connect(TreeLinkNode root) {
            TreeLinkNode p = root, first = null;
            while (p != null) {
                if (first == null) {
                    first = p.left;
                }
                if (p.left != null) {
                    p.left.next = p.right;
                } else {
                    break;
                }

                if (p.next != null) {
                    p.right.next = p.next.left;
                    p = p.next;
                } else {
                    p = first;
                    first = null;
                }
            }
        }
    }
}
