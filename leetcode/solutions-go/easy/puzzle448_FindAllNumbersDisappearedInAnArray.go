/*
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:
    Input:
        [4,3,2,7,8,2,3,1]
    Output:
        [5,6]
*/

package main

import "fmt"

func findDisappearedNumbers(nums []int) []int {
  nLen := len(nums)
  for i := 0; i < nLen; i++ {
    for nums[i] != i+1 && nums[i] != nums[nums[i]-1] {
      nums[nums[i]-1], nums[i] = nums[i], nums[nums[i]-1]
    }
  }

  idx := 0
  for i := 0; i < nLen; i++ {
    if nums[i] != i+1 {
      nums[idx] = i + 1
      idx++
    }
  }
  return nums[:idx]
}

func main() {
  fmt.Println(findDisappearedNumbers([]int{4, 3, 2, 7, 8, 2, 3, 1}))
  fmt.Println(p448_fastSolution(1).findDisappearedNumbers([]int{4, 3, 2, 7, 8, 2, 3, 1}))
}

type p448_fastSolution int

// tricky solution, can find disappeared numbers, but can't find duplicate numbers
func (p448_fastSolution) findDisappearedNumbers(nums []int) []int {
  var result []int
  for _, v := range nums {
    if v < 0 {
      v = -v
    }
    if nums[v-1] > 0 {
      nums[v-1] = -nums[v-1]
    }
  }

  for i := range nums {
    if nums[i] > 0 {
      result = append(result, i+1)
    }
  }

  return result
}
