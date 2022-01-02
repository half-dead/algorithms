/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:
    Given the sorted array: [-10,-3,0,5,9],
    One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

          0
         / \
       -3   9
       /   /
     -10  5
*/

package main

import "fmt"

func sortedArrayToBST(nums []int) *TreeNode {
  nLen := len(nums)
  if nLen == 0 {
    return nil
  }
  mid := nLen / 2
  return &TreeNode{
    Val:   nums[mid],
    Left:  sortedArrayToBST(nums[0:mid]),
    Right: sortedArrayToBST(nums[mid+1:]),
  }
}

type p108_stupidSolution int

func (p108_stupidSolution) sortedArrayToBST(nums []int) *TreeNode {
  nLen := len(nums)
  if nLen == 0 {
    return nil
  }
  mid := nLen / 2
  root := &TreeNode{Val: nums[mid]}

  parent := root
  left, right := mid-1, mid+1
  for ; left >= 0; left-- {
    subLeft := &TreeNode{Val: nums[left]}
    parent.Left, parent = subLeft, subLeft
  }
  parent = root
  for ; right < nLen; right++ {
    subRight := &TreeNode{Val: nums[right]}
    parent.Right, parent = subRight, subRight
  }
  return root
}

func main() {
  fmt.Println(PreOrderTraversal(sortedArrayToBST([]int{1, 2, 3, 4, 5, 6, 7, 8, 9})))
}
