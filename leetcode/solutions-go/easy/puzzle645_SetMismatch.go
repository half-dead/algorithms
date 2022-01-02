/*
https://leetcode.com/problems/set-mismatch/description/

The set S originally contains numbers from 1 to n. But unfortunately, due to the data error,
one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error.
Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

Example 1:
    Input: nums = [1,2,2,4]
    Output: [2,3]
Note:
    The given array size will in the range [2, 10000].
    The given array's numbers won't have any order.

*/

package main

import "fmt"

// The idea is: keep swapping elements in the array until all of them fall in order besides the missing number.
func findErrorNums(nums []int) []int {
  res := make([]int, 2, 2)
  numsLen := len(nums)
  for i := 0; i < numsLen; i++ {
    for nums[i] != i+1 {
      if nums[i] == nums[nums[i]-1] {
        res[0], res[1] = nums[i], i+1
        break
      } else {
        nums[i], nums[nums[i]-1] = nums[nums[i]-1], nums[i]
      }
    }
  }
  return res
}

func main() {
  fmt.Println(findErrorNums([]int{8, 7, 3, 5, 3, 6, 1, 4}))
}
