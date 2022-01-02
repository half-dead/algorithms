/*
https://leetcode.com/problems/single-number-iii/description/

Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
Find the two elements that appear only once.

For example:
  Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
  The order of the result is not important. So in the above example, [5, 3] is also correct.
  Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */

package main

import "fmt"

func singleNumber(nums []int) []int {
  dict := make(map[int]bool)
  for _, i := range nums {
    dict[i] = !dict[i]
  }

  res := make([]int, 0)
  for k, v := range dict {
    if v {
      res = append(res, k)
    }
  }
  return res
}

// could't understand the original algorithm
// but with a few modification, i can understand
func singleNumberNeat(nums []int) []int {
  diff, a, b := 0, 0, 0
  for _, num := range nums {
    diff ^= num
  }
  diff &= -diff
  for _, num := range nums {
    if num&diff == 0 {
      a ^= num
    } else {
      b ^= num
    }
  }
  return []int{a, b}
}

func main() {
  fmt.Println(24 & -24)

  // fmt.Println(singleNumberNeat([]int{1, 2, 1, 3, 2, 5}))
}
