// https://leetcode.com/problems/number-of-good-pairs/

package main

func numIdenticalPairs(nums []int) int {
  cnts := make(map[int]int)
  for _, n := range nums {
    cnts[n]++
  }

  answer := 0
  for _, cnt := range cnts {
    if cnt > 1 {
      answer += cnt * (cnt - 1) / 2
    }
  }
  return answer
}
