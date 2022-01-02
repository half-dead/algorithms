// https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/

package main

import "fmt"

func containsPattern(arr []int, m int, k int) bool {
  total := len(arr)
outer:
  for i := 0; i < total; i++ {
    if m*k > total-i {
      return false
    }

    for shift := 0; shift < m; shift++ {
      val := arr[i+shift]
      for p, j := i+shift, 0; j < k; j, p = j+1, p+m {
        if arr[p] != val {
          continue outer
        }
      }
    }
    return true
  }
  return false
}

func main() {
  fmt.Println(containsPattern([]int{1, 2, 4, 4, 4, 4}, 1, 3))
  fmt.Println(containsPattern([]int{1, 2, 1, 2, 1, 1, 1, 3}, 2, 2))
  fmt.Println(containsPattern([]int{1, 2, 1, 2, 1, 3}, 2, 3))
  fmt.Println(containsPattern([]int{1, 2, 3, 1, 2}, 2, 2))
  fmt.Println(containsPattern([]int{2, 2, 2, 2}, 2, 3))
}
