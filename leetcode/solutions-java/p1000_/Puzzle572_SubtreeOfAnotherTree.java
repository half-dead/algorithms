/*
https://leetcode.com/problems/subtree-of-another-tree/description/

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

  Example 1:
    Given tree s:
         3
        / \
       4   5
      / \
     1   2
    Given tree t:
       4
      / \
     1   2
    Return true, because t has the same structure and node values with a subtree of s.

  Example 2:
    Given tree s:
         3
        / \
       4   5
      / \
     1   2
        /
       0
    Given tree t:
       4
      / \
     1   2
    Return false.
 */

package p1000_;

import struct.TreeNode;

/**
 * A simple solution would be do a in-order traversal on both TreeNode at first
 * then search the output of TreeNode t in the output of TreeNode s
 *
 * @author half-dead
 */
public class Puzzle572_SubtreeOfAnotherTree {

    public static void main(String[] args) {
        Puzzle572_SubtreeOfAnotherTree p = new Puzzle572_SubtreeOfAnotherTree();
        Solution solution = p.new Solution();
        System.out.println(solution.isSubtree(new TreeNode("[3,4,5,1,2]"), new TreeNode("[4,1,2,1]")));
    }

    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            return recursive(s, t) || s.left != null && isSubtree(s.left, t) || s.right != null && isSubtree(s.right, t);
        }

        private boolean recursive(TreeNode s, TreeNode t) {
            return (s == null && t == null) || (s != null && t != null && s.val == t.val && recursive(s.left, t.left) && recursive(s.right, t.right));
        }
    }

}
