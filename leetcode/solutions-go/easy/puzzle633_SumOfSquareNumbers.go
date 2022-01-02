/*
https://leetcode.com/problems/sum-of-square-numbers/description/

Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:
  Input: 5
  Output: True
  Explanation: 1 * 1 + 2 * 2 = 5
Example 2:
  Input: 3
  Output: False
 */

package main

import (
  "fmt"
  "math"
)

func judgeSquareSum(c int) bool {
  root1 := int(math.Sqrt(float64(c)))
  for a := 0; a <= root1; a++ {
    b := int(math.Sqrt(float64(c - a*a)))
    if a*a+b*b == c {
      return true
    }
  }
  return false
}

func main() {
  fmt.Println(judgeSquareSum(5))
}
