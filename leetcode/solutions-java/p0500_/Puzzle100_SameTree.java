package p0500_;

// Given two binary trees, write a function to check if they are equal or not.
//
// Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

import struct.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/same-tree/
 */
public class Puzzle100_SameTree {

    public class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            LinkedList<TreeNode> pTree = new LinkedList<>();
            LinkedList<TreeNode> qTree = new LinkedList<>();
            if (p != null) pTree.push(p);
            if (q != null) qTree.push(q);
            while (pTree.size() > 0 && qTree.size() > 0) {
                TreeNode curp = pTree.pop();
                TreeNode curq = qTree.pop();
                boolean lp = curp.left != null, lq = curq.left != null;
                boolean rp = curp.right != null, rq = curq.right != null;
                if (curp.val != curq.val || (lp ^ lq) || (rp ^ rq)) {
                    return false;
                } else {
                    if (lp) pTree.push(curp.left);
                    if (lq) qTree.push(curq.left);
                    if (rp) pTree.push(curp.right);
                    if (rq) qTree.push(curq.right);
                }
            }
            return pTree.size() == qTree.size();
        }
    }


    public class RecursiveSolution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            } else if (p != null && q != null) {
                return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
            return false;
        }
    }
}
