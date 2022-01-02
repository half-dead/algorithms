// https://leetcode.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/

package main

import (
  "fmt"
)

func numTriplets(nums1 []int, nums2 []int) int {
  map1, map2 := make(map[int]int), make(map[int]int)
  for _, n := range nums1 {
    map1[n]++
  }
  for _, n := range nums2 {
    map2[n]++
  }
  return check(map1, map2) + check(map2, map1)
}

func check(map1, map2 map[int]int) int {
  var result int
  for a, ca := range map1 {
    squared := a * a
    for b, cb := range map2 {
      if squared%b == 0 {
        c := squared / b
        if cc, ok := map2[c]; ok {
          if b == c {
            result += ca * cb * (cb - 1)
          } else {
            result += ca * cb * cc
          }
        }
      }
    }
  }
  return result / 2
}

func main() {
  fmt.Println(numTriplets([]int{7, 4}, []int{5, 2, 8, 9}))
  fmt.Println(numTriplets([]int{1, 1}, []int{1, 1, 1}))
  fmt.Println(numTriplets([]int{7, 7, 8, 3}, []int{1, 2, 9, 7}))
  fmt.Println(numTriplets([]int{4, 7, 9, 11, 23}, []int{3, 5, 1024, 12, 18}))
}
