// https://leetcode.com/problems/kth-missing-positive-number/

package main

import "fmt"

func findKthPositive(arr []int, k int) int {
  prev := 0
  for _, n := range arr {
    missing := n - prev - 1
    if missing >= k {
      return prev + k
    }
    prev = n
    k -= missing
  }
  return prev + k
}

func main() {
  fmt.Println(findKthPositive([]int{2, 3, 4, 7, 11}, 5))
  fmt.Println(findKthPositive([]int{1, 2, 3, 4}, 2))
}
