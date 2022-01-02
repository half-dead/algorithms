/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2


*/

package main

import "fmt"

func twoSum(numbers []int, target int) []int {
  res := make([]int, 2, 2)
  nLen := len(numbers)

  left, right := 0, nLen-1
  for left < right {
    sum := numbers[left] + numbers[right]
    if sum == target {
      res[0], res[1] = left+1, right+1
      break
    } else if sum > target {
      right--
    } else {
      left++
    }
  }
  return res
}

func main() {
  fmt.Println(twoSum([]int{2, 3, 4}, 6))
}
