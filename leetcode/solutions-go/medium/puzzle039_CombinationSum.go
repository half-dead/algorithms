/*
https://leetcode.com/problems/combination-sum/description/

Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:
[
  [7],
  [2, 2, 3]
]
*/

package main

import (
  "fmt"
  "sort"
)

func combinationSum(candidates []int, target int) [][]int {
  sort.Ints(candidates)
  res := make([][]int, 0)
  dfs039(candidates, target, []int{}, &res)
  return res
}

func dfs039(candidates []int, target int, curr []int, res *[][]int) {
  if target == 0 {
    *res = append(*res, curr)
    return
  }
  for i := 0; i < len(candidates); i++ {
    if candidates[i] > target {
      break
    }

    times := 1
    for ; candidates[i]*times <= target; times++ {
      dup := make([]int, len(curr))
      copy(dup, curr)
      for j := times; j > 0; j-- {
        dup = append(dup, candidates[i])
      }
      taken := candidates[i] * times
      dfs039(candidates[i+1:], target-taken, dup, res)
    }
  }
}

func main() {
  fmt.Println(combinationSum([]int{1, 2, 3, 6, 7}, 7))
}
