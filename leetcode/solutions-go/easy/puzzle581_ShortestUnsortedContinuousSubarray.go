/*
https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/

Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
  Input: [2, 6, 4, 8, 10, 9, 15]
  Output: 5
  Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
  Then length of the input array is in range [1, 10,000].
  The input array may contain duplicates, so ascending order here means <=.

 */

package main

import (
  "fmt"
  "sort"
  "math"
)

func findUnsortedSubarray(nums []int) int {
  left, right := len(nums)-1, 0
  min, max := math.MaxInt32, math.MinInt32
  for i := 0; i < len(nums)-1; i++ {
    if nums[i] > nums[i+1] {
      if i < left {
        left = i
      }
      if i >= right {
        right = i + 1
      }
      if nums[i+1] < min {
        min = nums[i+1]
      }
      if nums[i] > max {
        max = nums[i]
      }
    }
  }
  if left >= right {
    return 0
  }

  for i := 0; i < left; i++ {
    if nums[i] > min {
      left = i
      break;
    }
  }

  for i := len(nums) - 1; i > right; i-- {
    if nums[i] < max {
      right = i
      break
    }
  }

  return right - left + 1
}

// this solution is STUPID
func findUnsortedSubarrayStupidSolution(nums []int) int {
  dup := make([]int, len(nums))
  copy(dup, nums)
  sort.Ints(dup)

  i, j := 0, len(nums)-1
  for ; i < len(nums); i++ {
    if nums[i] != dup[i] {
      break;
    }
  }
  for ; j > i; j-- {
    if nums[j] != dup[j] {
      break;
    }
  }
  return j - i + 1
}

func main() {
  fmt.Println(findUnsortedSubarray([]int{2, 1}))
}
