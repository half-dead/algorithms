/*
https://leetcode.com/problems/merge-two-binary-trees/description/

Given two binary trees and imagine that when you put one of them to cover the other,
some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
then sum node values up as the new value of the merged node.
Otherwise, the NOT null node will be used as the node of new tree.

Example 1:
  Input:
    Tree 1                     Tree 2
            1                         2
           / \                       / \
          3   2                     1   3
         /                           \   \
        5                             4   7
  Output:
  Merged tree:
         3
        / \
       4   5
      / \   \
     5   4   7
Note: The merging process must start from the root nodes of both trees.
 */

package main

func mergeTrees(t1 *TreeNode, t2 *TreeNode) *TreeNode {
  if t1 == nil && t2 == nil {
    return nil
  }
  sum := 0
  var left1, left2, right1, right2 *TreeNode
  if t1 != nil {
    sum += t1.Val
    left1, right1 = t1.Left, t1.Right
  }
  if t2 != nil {
    sum += t2.Val
    left2, right2 = t2.Left, t2.Right
  }
  return &TreeNode{Val: sum, Left: mergeTrees(left1, left2), Right: mergeTrees(right1, right2)}
}
