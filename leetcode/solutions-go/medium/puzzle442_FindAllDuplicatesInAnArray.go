/*
https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?

Example:
  Input:
  [4,3,2,7,8,2,3,1]
  Output:
  [2,3]
 */

package main

import "fmt"

func findDuplicates(nums []int) []int {
  res := make([]int, 0)

  for i := 0; i < len(nums); i++ {
    for ; nums[i] != i+1 && nums[i] != nums[nums[i]-1]; {
      nums[i], nums[nums[i]-1] = nums[nums[i]-1], nums[i]
    }
  }

  for i := 0; i < len(nums); i++ {
    if nums[i] != i+1 {
      res = append(res, nums[i])
    }
  }
  return res
}

func main() {
  fmt.Println(findDuplicates([]int{4, 3, 2, 7, 8, 2, 3, 1}))
}
