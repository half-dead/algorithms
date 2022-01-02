/*
https://leetcode.com/problems/find-mode-in-binary-search-tree/description/

Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:
    The left subtree of a node contains only nodes with keys less than or equal to the node's key.
    The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
    Both the left and right subtrees must also be binary search trees.

For example:
    Given BST [1,null,2,2],
       1
        \
         2
        /
       2
    return [2].

Note: If a tree has more than one mode, you can return them in any order.
Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
*/

package main

func findMode(root *TreeNode) []int {
  dict := make(map[int]int)
  recursive501(root, dict)

  maxCount := 0
  for _, v := range dict {
    if v > maxCount {
      maxCount = v
    }
  }

  res := make([]int, 0)
  for k, v := range dict {
    if v == maxCount {
      res = append(res, k)
    }
  }

  return res
}

func recursive501(root *TreeNode, stat map[int]int) {
  if root == nil {
    return
  }

  if v, ok := stat[root.Val]; ok {
    stat[root.Val] = v + 1
  } else {
    stat[root.Val] = 1
  }
  recursive501(root.Left, stat)
  recursive501(root.Right, stat)
}

func main() {

}
