/*
https://leetcode.com/problems/maximum-binary-tree/description/

Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
  The root is the maximum number in the array.
  The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
  The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
  Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
  Input: [3,2,1,6,0,5]
  Output: return the tree root node representing the following tree:

        6
      /   \
     3     5
      \    /
       2  0
         \
          1
Note:
  The size of the given array will be in the range [1,1000].
 */

package main

func constructMaximumBinaryTree(nums []int) *TreeNode {
  if len(nums) == 0 {
    return nil
  }
  idx, max := 0, nums[0]
  for i, n := range nums {
    if max < n {
      idx, max = i, n
    }
  }
  return &TreeNode{
    Val:   max,
    Left:  constructMaximumBinaryTree(nums[0:idx]),
    Right: constructMaximumBinaryTree(nums[idx+1:]),
  }
}
