package p0500_;

// Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
//
// For example:
// Given the below binary tree and sum = 22,
//       5
//      / \
//     4   8
//    /   / \
//   11  13  4
//  /  \      \
// 7    2      1
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

import struct.TreeNode;

/**
 * https://leetcode.com/problems/path-sum/
 */
public class Puzzle112_PathSum {

    public class RecursiveSolution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) return false;
            if (root.left == null && root.right == null && root.val == sum) return true;
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
