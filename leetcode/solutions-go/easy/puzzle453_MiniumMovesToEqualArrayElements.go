/*
https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/

Given a non-empty integer array of size n, find the minimum number of moves required
to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

  Input:
  [1,2,3]

  Output:
  3

Explanation:
  Only three moves are needed (remember each move increments two elements):
  [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */

package main

import (
  "fmt"
  "sort"
  "math"
)

// stupid
func minMoves(nums []int) int {
  size := len(nums)
  sort.Ints(nums)
  min, max := nums[0], nums[size-1]
  if min == max {
    return 0
  }

  maxIndex := size - 1
  res := 0
  for ; min != max; {
    res += max - min
    maxIndex--
    min, max = max, nums[maxIndex]+res
  }
  return res
}

type p453_NeatSolution int

func (p453_NeatSolution) minMoves(nums []int) int {
  min := math.MaxInt32
  for _, i := range nums {
    if i < min {
      min = i
    }
  }
  res := 0
  for _, i := range nums {
    res += i - min
  }
  return res
}

func main() {
  fmt.Println(p453_NeatSolution(5).minMoves([]int{5, 6, 8, 8, 5}))
}
