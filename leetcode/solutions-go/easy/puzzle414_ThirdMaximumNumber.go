/*
https://leetcode.com/problems/third-maximum-number/description/

Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
    Input: [3, 2, 1]
    Output: 1
    Explanation: The third maximum is 1.
Example 2:
    Input: [1, 2]
    Output: 2
    Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
    Input: [2, 2, 3, 1]
    Output: 1
    Explanation: Note that the third maximum here means the third maximum distinct number.
    Both numbers with value 2 are both considered as second maximum.
*/
package main

import (
  "fmt"
  "math"
)

func main() {
  fmt.Println(thirdMax([]int{1, 2, math.MinInt32}))
}

func thirdMax(nums []int) int {
  c1, c2, c3 := 0, 0, 0
  max1, max2, max3 := math.MinInt64, math.MinInt64, math.MinInt64

  for _, n := range nums {
    if n > max1 {
      c1++
      max1, max2, max3 = n, max1, max2
    } else if n == max1 {
    } else if n > max2 {
      c2++
      max2, max3 = n, max2
    } else if n == max2 {
    } else if n >= max3 {
      c3++
      max3 = n
    }
  }
  flag := false
  if c1+c2+c3 >= 3 {
    flag = true
  }
  if flag {
    return max3
  } else {
    return max1
  }
}

type p414_BetterSolution int

func (p414_BetterSolution) thirdMax(nums []int) int {
  const kMax = 3
  hasValue := [kMax]bool{}
  maxValue := [kMax]int{}
  for _, v := range nums {
    for i := 0; i < kMax; i++ {
      if hasValue[i] {
        if v == maxValue[i] {
          break
        }
        if v > maxValue[i] {
          v, maxValue[i] = maxValue[i], v
        }
      } else {
        maxValue[i] = v
        hasValue[i] = true
        break
      }
    }
  }
  if hasValue[kMax-1] {
    return maxValue[kMax-1]
  }
  return maxValue[0]
}
