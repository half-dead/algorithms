/*
https://leetcode.com/problems/power-of-four/description/

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?
*/
package main

import "fmt"

func isPowerOfFour(num int) bool {
  if num <= 0 {
    return false
  }
  for num != 0 {
    if num == 1 {
      return true
    }
    if num%4 != 0 {
      return false
    }
    num = num / 4
  }
  return false
}

type p344NoLoopSolution struct{}

func (p344NoLoopSolution) isPowerOfFour(num int) bool {
  return num > 0 && num&(num-1) == 0 && num&0x55555555 != 0
}

func main() {
  fmt.Println(isPowerOfFour(4))
  fmt.Println(isPowerOfFour(16))
  fmt.Println(isPowerOfFour(64))
  fmt.Println(isPowerOfFour(3))
  fmt.Println(isPowerOfFour(8))

  t := &p344NoLoopSolution{}
  fmt.Println(t.isPowerOfFour(4))
}
