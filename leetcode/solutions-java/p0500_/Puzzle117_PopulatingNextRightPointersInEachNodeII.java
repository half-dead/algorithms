/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/

Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node.
If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:
    You may only use constant extra space.
    Recursive approach is fine, implicit stack space does not count as extra space for this problem.

Example:
    Given the following binary tree,

         1
       /  \
      2    3
     / \    \
    4   5    7
    After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */

package p0500_;

import struct.TreeLinkNode;

/**
 * @author half-dead
 */
public class Puzzle117_PopulatingNextRightPointersInEachNodeII {

    public static void main(String[] args) {
        Puzzle117_PopulatingNextRightPointersInEachNodeII p = new Puzzle117_PopulatingNextRightPointersInEachNodeII();
        Solution s = p.new Solution();
        RecursiveSolution rs = p.new RecursiveSolution();

        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode left = new TreeLinkNode(2);
        TreeLinkNode right = new TreeLinkNode(3);
        left.left = new TreeLinkNode(4);
        right.right = new TreeLinkNode(5);
        root.left = left;
        root.right = right;

        rs.connect(root);
        System.out.println("skdfhj");
    }


    // Iterative solution, too complicated
    public class Solution {
        public void connect(TreeLinkNode root) {
            if (root == null) {
                return;
            }
            TreeLinkNode parent = root;
            TreeLinkNode child = root;
            TreeLinkNode childLeft = root;
            while (parent != null) {
                if (child == parent) {
                    child = parent.left == null ? parent.right : parent.left;
                }
                if (child != null) {
                    childLeft = child;
                }
                while (child != null && parent != null) {
                    TreeLinkNode node = null;
                    boolean b = true;
                    while (node == null || node == child) {
                        if (b) {
                            node = parent.left;
                            b = false;
                        } else {
                            node = parent.right;
                            b = true;
                            parent = parent.next;
                        }
                        if (parent == null) {
                            break;
                        }
                    }
                    if (node != null && node != child) {
                        child.next = node;
                    }
                    child = child.next;
                }
                parent = childLeft;
                boolean b = true;
                child = null;
                while (child == null && childLeft != null) {
                    if (b) {
                        child = childLeft.left;
                        b = false;
                    } else {
                        child = childLeft.right;
                        b = true;
                        childLeft = childLeft.next;
                    }
                }
            }
        }
    }

    public class RecursiveSolution {
        public void connect(TreeLinkNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                if (root.right != null) {
                    root.left.next = root.right;
                } else {
                    TreeLinkNode tempNext = root.next;
                    while (tempNext != null) {
                        if (tempNext.left != null) {
                            root.left.next = tempNext.left;
                            break;
                        } else if (tempNext.right != null) {
                            root.left.next = tempNext.right;
                            break;
                        }
                        tempNext = tempNext.next;
                    }
                }
            }
            if (root.right != null) {
                TreeLinkNode tempNext = root.next;
                while (tempNext != null) {
                    if (tempNext.left != null) {
                        root.right.next = tempNext.left;
                        break;
                    } else if (tempNext.right != null) {
                        root.right.next = tempNext.right;
                        break;
                    }
                    tempNext = tempNext.next;
                }
            }
            connect(root.right);
            connect(root.left);

        }
    }
}
