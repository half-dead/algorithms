// https://leetcode.com/problems/ways-to-make-a-fair-array/

package main

import "fmt"

func waysToMakeFair(nums []int) int {
  res := 0
  evenRight, oddRight := 0, 0
  evenLeft, oddLeft := 0, 0
  for i, n := range nums {
    if i%2 == 0 {
      evenRight += n
    } else {
      oddRight += n
    }
  }

  for i, n := range nums {
    if i%2 == 0 {
      evenRight -= n
    } else {
      oddRight -= n
    }
    if evenLeft+oddRight == oddLeft+evenRight {
      res++
    }
    if i%2 == 0 {
      evenLeft += n
    } else {
      oddLeft += n
    }
  }
  return res
}

func main() {
  fmt.Println(waysToMakeFair([]int{2, 1, 6, 4}))
  fmt.Println(waysToMakeFair([]int{1, 1, 1}))
  fmt.Println(waysToMakeFair([]int{1, 2, 3}))
}
