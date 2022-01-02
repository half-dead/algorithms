/*
https://leetcode.com/problems/subarray-product-less-than-k/description/

Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:
  Input: nums = [10, 5, 2, 6], k = 100
  Output: 8
  Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
  Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Note:
  0 < nums.length <= 50000.
  0 < nums[i] < 1000.
  0 <= k < 10^6.
 */

package main

import "fmt"

// simple solution, easy to understand
func numSubarrayProductLessThanK(nums []int, k int) int {
  if k < 2 {
    return 0
  }
  head, p, res := 0, 1, 0
  for i := 0; i < len(nums); i++ {
    if nums[i] != 1 {
      p *= nums[i]
    }
    for p >= k {
      res += i - head
      p /= nums[head]
      head ++
    }
  }
  if p < k {
    res += (len(nums) - head) * (len(nums) - head + 1) / 2
  }
  return res
}

func main() {
  arr := make([]int, 40000)
  for i := 0; i < 40000; i++ {
    arr[i] = 1
  }
  fmt.Println(numSubarrayProductLessThanK(arr, 2))
}
