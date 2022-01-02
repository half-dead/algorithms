/*
https://leetcode.com/problems/intersection-of-two-arrays-ii/description/

Given two arrays, write a function to compute their intersection.

Example:
    Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.
Follow up:
    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

*/

package main

import "fmt"

func intersect(nums1 []int, nums2 []int) []int {
  map1 := make(map[int]int)
  map2 := make(map[int]int)
  for _, n := range nums1 {
    if _, ok := map1[n]; ok {
      map1[n]++
    } else {
      map1[n] = 1
    }
  }
  for _, n := range nums2 {
    if _, ok := map2[n]; ok {
      map2[n]++
    } else {
      map2[n] = 1
    }
  }
  len1 := len(map1)
  len2 := len(map2)

  a, b := map1, map2
  if len1 > len2 {
    a, b = map2, map1
  }

  res := make([]int, 0)
  for k, v1 := range a {
    if v2, ok := b[k]; ok {
      size := v1
      if v1 > v2 {
        size = v2
      }
      for ; size > 0; size-- {
        res = append(res, k)
      }
    }
  }

  return res
}

func main() {
  fmt.Println(intersect([]int{1, 2, 2, 1}, []int{2, 2}))
}
