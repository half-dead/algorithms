/*
https://leetcode.com/problems/single-element-in-a-sorted-array/description/

Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.

  Example 1:
    Input: [1,1,2,3,3,4,4,8,8]
    Input: [1,1,3,3,4,8,8]
    Output: 2
  Example 2:
    Input: [3,3,7,7,10,11,11]
    Output: 10
Note: Your solution should run in O(log n) time and O(1) space.
 */

package main

import "fmt"

func singleNonDuplicate(nums []int) int {
  left, right := 0, len(nums)-1
  for ; left < right; {
    mid := (left + right) / 2
    if nums[mid] == nums[mid-1] {
      leftHalf := mid - 2 - left + 1
      if leftHalf%2 == 0 {
        left = mid + 1
      } else {
        right = mid - 2
      }
    } else if nums[mid] == nums[mid+1] {
      leftHalf := mid - 1 - left + 1
      if leftHalf%2 == 0 {
        left = mid + 2
      } else {
        right = mid - 1
      }
    } else {
      return nums[mid]
    }
  }
  return nums[left]
}

func main() {
  fmt.Println(singleNonDuplicate([]int{1, 1, 2, 3, 3, 4, 4, 8, 8}))
}
