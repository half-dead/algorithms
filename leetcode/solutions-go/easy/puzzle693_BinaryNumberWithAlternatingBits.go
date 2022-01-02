/*
https://leetcode.com/problems/binary-number-with-alternating-bits/description/

Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

Example 1:
  Input: 5
  Output: True
  Explanation:
  The binary representation of 5 is: 101
Example 2:
  Input: 7
  Output: False
  Explanation:
  The binary representation of 7 is: 111.
Example 3:
  Input: 11
  Output: False
  Explanation:
  The binary representation of 11 is: 1011.
Example 4:
  Input: 10
  Output: True
  Explanation:
  The binary representation of 10 is: 1010.
 */

package main

import "fmt"

func hasAlternatingBits(n int) bool {
  mod := -1
  for ; n > 0; {
    if n == 0 || n == 3 {
      return false
    }
    if mod == -1 {
      mod = n & 3
    } else {
      if n&3 != mod {
        return false
      }
    }
    n >>= 2
  }
  return true
}

func main() {
  fmt.Println(hasAlternatingBits(5))
  fmt.Println(hasAlternatingBits(10))
  fmt.Println(hasAlternatingBits(7))
  fmt.Println(hasAlternatingBits(11))
}
