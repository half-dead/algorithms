/*
https://leetcode.com/problems/max-consecutive-ones/description/

Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
  Input: [1,1,0,1,1,1]
  Output: 3
  Explanation: The first two digits or the last three digits are consecutive 1s.
      The maximum number of consecutive 1s is 3.
Note:
  The input array will only contain 0 and 1.
  The length of input array is a positive integer and will not exceed 10,000

 */

package main

import "fmt"

func findMaxConsecutiveOnes(nums []int) int {
  count, max := 0, 0
  for _, i := range nums {
    if i == 1 {
      count++
    } else {
      if count > max {
        max = count
      }
      count = 0
    }
  }
  if count > max {
    max = count
  }
  return max
}

func main() {
  fmt.Println(findMaxConsecutiveOnes([]int{1, 1, 0, 1, 1, 1}))
}
