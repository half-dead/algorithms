/*
https://leetcode.com/problems/maximum-average-subarray-i/description/

Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value.
And you need to output the maximum average value.

Example 1:
  Input: [1,12,-5,-6,50,3], k = 4
  Output: 12.75
  Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
Note:
  1 <= k <= n <= 30,000.
  Elements of the given array will be in the range [-10,000, 10,000].
 */

package main

import (
  "fmt"
  "math"
)

func findMaxAverage(nums []int, k int) float64 {
  max := math.MinInt32
  sum := 0
  for i, j := 0, 0; i < len(nums); {
    sum += nums[i]
    i++
    if j < k {
      j++
    }
    if j == k {
      if sum > max {
        max = sum
      }
      sum -= nums[i-k]
    }
  }
  return float64(max) / float64(k)
}

func main() {
  fmt.Println(findMaxAverage([]int{1, 12, -5, -6, 50, 3}, 4))
}
