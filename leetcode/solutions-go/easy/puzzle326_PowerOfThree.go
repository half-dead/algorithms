/*
https://leetcode.com/problems/power-of-three/description/

Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
*/
package main

import (
  "fmt"
  "strconv"
)

func isPowerOfThree(n int) bool {
  return n > 0 && 1162261467%n == 0
}

func main() {

  n := 1
  for i := 1; i <= 15; i++ {
    n *= 3
    fmt.Printf("%30s\n", strconv.FormatInt(int64(n), 2))
  }
}
