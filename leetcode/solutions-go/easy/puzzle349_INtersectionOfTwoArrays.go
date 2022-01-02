/*
https://leetcode.com/problems/intersection-of-two-arrays/description/

Given two arrays, write a function to compute their intersection.

Example:
    Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
    Each element in the result must be unique.
    The result can be in any order.
*/

package main

import "fmt"

func intersection(nums1 []int, nums2 []int) []int {
  map1 := make(map[int]bool)
  map2 := make(map[int]bool)
  for _, n := range nums1 {
    map1[n] = true
  }
  for _, n := range nums2 {
    map2[n] = true
  }
  len1 := len(map1)
  len2 := len(map2)

  a, b := map1, map2
  if len1 > len2 {
    a, b = map2, map1
  }

  res := make([]int, 0)
  for k := range a {
    if _, ok := b[k]; ok {
      res = append(res, k)
    }
  }

  return res
}

func main() {
  fmt.Println(intersection([]int{1, 2, 2, 1}, []int{2, 2}))
}
