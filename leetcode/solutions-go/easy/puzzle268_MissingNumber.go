/*
https://leetcode.com/problems/missing-number/description/

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1

    Input: [3,0,1]
    Output: 2
Example 2

    Input: [9,6,4,2,3,5,7,0,1]
    Output: 8

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
*/

package main

func missingNumber(nums []int) int {
  max := len(nums)
  sum := 0
  for _, n := range nums {
    sum += n
  }

  expectedSum := (max + 1) * max / 2
  return expectedSum - sum
}

type puzzle268XorSolution int

func (puzzle268XorSolution) missingNumber(nums []int) int {
  missing := len(nums)
  for i, num := range nums {
    missing ^= i ^ num
  }
  return missing
}

func main() {

}
