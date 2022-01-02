/*
https://leetcode.com/problems/valid-perfect-square/description/
Given a positive integer num, write a function which returns True if num is a perfect square else False.
Note: Do not use any built-in library function such as sqrt.

Example 1:
    Input: 16
    Returns: True
Example 2:
    Input: 14
    Returns: False
*/

package main

import "fmt"

func isPerfectSquare(num int) bool {
  left, right := 1, num/2
  if left > right {
    left, right = right, left
  }

  for left <= right {
    mid := (left + right) / 2
    sq := mid * mid
    if sq == num {
      return true
    } else if sq < num {
      left = mid + 1
    } else {
      right = mid - 1
    }
  }
  return false
}

func main() {
  fmt.Println(isPerfectSquare(5))
}
