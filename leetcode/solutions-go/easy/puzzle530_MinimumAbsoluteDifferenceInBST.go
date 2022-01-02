/*
https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/

Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:
  Input:
     1
      \
       3
      /
     2

  Output:
    1
  Explanation:
    The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
Note: There are at least two nodes in this BST.


 */

package main

import (
  "math"
  "fmt"
)

func getMinimumDifference(root *TreeNode) int {
  arr := make([]int, 0)
  inOrderTraversal(root, &arr)
  res := math.MaxInt32
  for i := 0; i < len(arr)-1; i++ {
    diff := arr[i+1] - arr[i]
    if diff < res {
      res = diff
    }
  }
  return res
}

func inOrderTraversal(root *TreeNode, arr *[]int) {
  if root.Left != nil {
    inOrderTraversal(root.Left, arr)
  }
  *arr = append(*arr, root.Val)
  if root.Right != nil {
    inOrderTraversal(root.Right, arr)
  }
}

func main() {
  fmt.Println(getMinimumDifference(NewTreeNodeFromString("[1,null,3,2]")))
}
