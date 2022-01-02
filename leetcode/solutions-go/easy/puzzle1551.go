// https://leetcode.com/problems/minimum-operations-to-make-array-equal/

package main

func minOperations(n int) int {
  half := n / 2
  result := half * half
  if n%2 != 0 {
    result += half
  }
  return result
}

func minOperations2(n int) int {
  return (n * n) / 4
}
