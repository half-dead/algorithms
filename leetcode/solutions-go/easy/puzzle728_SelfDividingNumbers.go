/*
https://leetcode.com/problems/self-dividing-numbers/description/

A self-dividing number is a number that is divisible by every digit it contains.
For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
Also, a self-dividing number is not allowed to contain the digit zero.
Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:
  Input:
  left = 1, right = 22
  Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
Note:
  The boundaries of each input argument are 1 <= left <= right <= 10000.
 */

package main

import (
  "fmt"
)

func selfDividingNumbers(left int, right int) []int {
  res := make([]int, 0)
  for i := left; i <= right; i++ {
    if isSelfDividingNumber(i) {
      res = append(res, i)
    }
  }
  return res
}

func isSelfDividingNumber(n int) bool {
  for m := n; m > 0; {
    d := m % 10
    if d == 0 || n%d != 0 {
      return false
    }
    m /= 10
  }
  return true
}

func main() {
  fmt.Println(selfDividingNumbers(66, 708))
}
