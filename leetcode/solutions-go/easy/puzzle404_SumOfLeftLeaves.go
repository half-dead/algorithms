/*
https://leetcode.com/problems/sum-of-left-leaves/description/

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

*/

package main

func sumOfLeftLeaves(root *TreeNode) (sum int) {
  if root != nil {
    if root.Left != nil && root.Left.Left == nil && root.Left.Right == nil {
      sum += root.Left.Val
    } else {
      sum += sumOfLeftLeaves(root.Left)
    }
    sum += sumOfLeftLeaves(root.Right)
  }
  return sum
}
