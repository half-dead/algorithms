/*
https://leetcode.com/problems/average-of-levels-in-binary-tree/description/

Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
  Input:
      3
     / \
    9  20
      /  \
     15   7
  Output: [3, 14.5, 11]
  Explanation:
  The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
  The range of node's value is in the range of 32-bit signed integer.
 */

package main

import "fmt"

func averageOfLevels(root *TreeNode) []float64 {
  dict := make(map[int][]int)
  dfs637(root, dict, 0)
  res := make([]float64, 0)
  for i := 0; i < len(dict); i++ {
    res = append(res, float64(dict[i][0])/float64(dict[i][1]))
  }
  return res
}

func dfs637(root *TreeNode, dict map[int][]int, level int) {
  if root != nil {
    var arr []int
    var ok bool
    if arr, ok = dict[level]; !ok {
      arr = make([]int, 2)
      dict[level] = arr
    }
    arr[0] += root.Val
    arr[1]++
    dfs637(root.Left, dict, level+1)
    dfs637(root.Right, dict, level+1)
  }
}

func main() {
  fmt.Println(averageOfLevels(NewTreeNodeFromString("[3,9,20,15,7]")))
}
