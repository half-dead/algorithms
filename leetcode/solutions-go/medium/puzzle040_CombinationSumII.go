/*
https://leetcode.com/problems/combination-sum-ii/description/

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/

package main

import (
  "fmt"
  "sort"
)

func combinationSum2(candidates []int, target int) [][]int {
  sort.Ints(candidates)
  res := make([][]int, 0)
  dfs040(candidates, target, []int{}, &res)
  return res
}

func dfs040(candidates []int, target int, curr []int, res *[][]int) {
  if target == 0 {
    *res = append(*res, curr)
    return
  }
  for i := 0; i < len(candidates); i++ {
    if candidates[i] > target {
      break
    }

    appearance := 1
    for j := i; j < len(candidates)-1 && candidates[j] == candidates[j+1]; j++ {
      appearance++
    }

    times := 1
    for ; times <= appearance && candidates[i]*times <= target; times++ {
      dup := make([]int, len(curr))
      copy(dup, curr)
      for k := times; k > 0; k-- {
        dup = append(dup, candidates[i])
      }
      taken := candidates[i] * times
      dfs040(candidates[i+appearance:], target-taken, dup, res)
    }
    i += appearance - 1
  }
}

func main() {
  fmt.Println(combinationSum2([]int{10, 1, 2, 7, 6, 1, 5}, 8))
}

type p040_3msSolution struct{}

func (p040_3msSolution) combinationSum2(candidates []int, target int) [][]int {
  var buf []int
  var out [][]int

  sort.Ints(candidates)
  combinationDfs2(candidates, 0, target, &buf, &out)

  return out
}

func combinationDfs2(candidates []int, start int, target int, curr *[]int, res *[][]int) {
  if target == 0 {
    found := make([]int, len(*curr))
    copy(found, *curr)
    *res = append(*res, found)
  } else {
    for j := start; j < len(candidates); j++ {
      if j > start && candidates[j] == candidates[j-1] {
        continue
      }

      d := candidates[j]

      if target < d {
        break
      }

      *curr = append(*curr, d)
      combinationDfs2(candidates, j+1, target-d, curr, res)
      *curr = (*curr)[:len(*curr)-1]
    }
  }
}
