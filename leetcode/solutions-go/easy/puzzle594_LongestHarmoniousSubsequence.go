/*
https://leetcode.com/problems/longest-harmonious-subsequence/description/

We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

Example 1:
  Input: [1,3,2,2,5,2,3,7]
  Output: 5
  Explanation: The longest harmonious subsequence is [3,2,2,2,3].

Note: The length of the input array will not exceed 20,000.
 */

package main

import (
  "fmt"
)

func findLHS(nums []int) int {
  dict := make(map[int]int, len(nums))
  for _, n := range nums {
    dict[n]++
  }

  max := 0
  for k, v1 := range dict {
    if v2, ok := dict[k+1]; ok {
      sum := v1 + v2
      if max < sum {
        max = sum
      }
    }
  }

  return max
}

func main() {
  fmt.Println(findLHS([]int{1, 3, 2, 2, 5, 2, 3, 7}))
}
