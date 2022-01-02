/*
https://leetcode.com/problems/counting-bits/description/

Given a non negative integer number num.
For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
  For num = 5 you should return [0,1,1,2,1,2].

Follow up:
  It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
  Space complexity should be O(n).
  Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */

package main

import "fmt"

func countBits(num int) []int {
  res := make([]int, num+1)
  res[0] = 0
  distance := 1
  for i := 1; i < num+1; i++ {
    if i > 1 && i&(i-1) == 0 {
      distance <<= 1
    }
    res[i] = res[i-distance] + 1
  }
  return res
}

// dp solution, clever
func countBitsDPSolution(num int) []int {
  res := make([]int, num+1)
  res[0] = 0
  for i := 1; i <= num; i++ {
    if i%2 == 0 {
      res[i] = res[i/2]
    } else {
      res[i] = res[i-1] + 1
    }
  }
  return res
}

func main() {
  fmt.Println(countBits(987))
}
