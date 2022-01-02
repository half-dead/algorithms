/*
https://leetcode.com/problems/subsets/description/

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

package main

import "fmt"

func subsets(nums []int) [][]int {
  max := len(nums)
  res := &[][]int{}
  for i := 0; i <= max; i++ {
    dfs078(nums, i, 0, []int{}, res)
  }
  return *res
}

func dfs078(nums []int, numLeft, start int, curr []int, res *[][]int) {
  if numLeft == 0 {
    dup := make([]int, len(curr))
    copy(dup, curr)
    *res = append(*res, dup)
    return
  }
  if numLeft > len(nums)-start {
    return
  }
  curr = append(curr, nums[start])
  dfs078(nums, numLeft-1, start+1, curr, res)
  curr = curr[:len(curr)-1]
  dfs078(nums, numLeft, start+1, curr, res)
}

func main() {
  fmt.Println(subsets([]int{1, 2, 3}))
}
