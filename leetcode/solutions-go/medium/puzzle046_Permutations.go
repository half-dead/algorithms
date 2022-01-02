/*
https://leetcode.com/problems/permutations/description/

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

package main

import "fmt"

func permute(nums []int) [][]int {
	res := make([][]int, 0)
	dfs046(nums, []int{}, &res)
	return res
}

func dfs046(nums []int, curr []int, res *[][]int) {
	if len(nums) == 1 {
		*res = append(*res, append(curr, nums[0]))
	}

	for i := 0; i < len(nums); i++ {
		nums[0], nums[i] = nums[i], nums[0]
		dup := append(curr, nums[0])
		dfs046(nums[1:], dup, res)
		nums[0], nums[i] = nums[i], nums[0]
	}
}

func main() {
	for _, arr := range permute([]int{1, 2, 3, 4, 5}) {
		fmt.Println(arr)
	}
}
