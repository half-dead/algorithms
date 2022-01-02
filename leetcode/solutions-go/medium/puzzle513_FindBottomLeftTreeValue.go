/*
https://leetcode.com/problems/find-bottom-left-tree-value/description/

Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
  Input:
      2
     / \
    1   3
  Output:
    1
Example 2:
  Input:
          1
         / \
        2   3
       /   / \
      4   5   6
         /
        7
  Output:
  7
Note: You may assume the tree (i.e., the given root node) is not NULL.
 */

package main

func findBottomLeftValue(root *TreeNode) int {
  return dfs513(root, 0)[0]
}

func dfs513(root *TreeNode, level int) []int {
  res := []int{root.Val, level}
  if root.Right != nil {
    res = dfs513(root.Right, level+1)
  }
  if root.Left != nil {
    t2 := dfs513(root.Left, level+1)
    if t2[1] >= res[1] {
      res = t2
    }
  }
  return res
}
