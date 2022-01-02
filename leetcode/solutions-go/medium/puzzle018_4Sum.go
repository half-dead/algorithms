/*
https://leetcode.com/problems/4sum/description/

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/
package main

import (
  "fmt"
  "sort"
  "strconv"
)

func fourSum(nums []int, target int) [][]int {
  sort.Ints(nums)

  curr := make([]int, 0, 0)
  res := make([][]int, 0, 0)
  recursiveNSum(nums, 4, target, curr, &res)
  return res
}

func recursiveNSum(nums []int, numLeft, target int, curr []int, res *[][]int) {

  if len(nums) < numLeft || numLeft < 2 || nums[0]*numLeft > target || nums[len(nums)-1]*numLeft < target {
    return
  }

  if numLeft == 2 {
    left, right := 0, len(nums)-1
    for left < right {
      sum := nums[left] + nums[right]
      if sum == target {
        *res = append(*res, append(curr, nums[left], nums[right]))
        for left < right && nums[left] == nums[left+1] {
          left++
        }
        for left < right && nums[right] == nums[right-1] {
          right--
        }
        left++
        right--
      } else if sum > target {
        right--
      } else {
        left++
      }
    }

  } else {
    for i := 0; i < len(nums)-numLeft+1; i++ {
      if i == 0 || nums[i] != nums[i-1] {
        recursiveNSum(nums[i+1:], numLeft-1, target-nums[i], append(curr, nums[i]), res)
      }
    }
  }
}

func main() {
  fmt.Println(fourSum([]int{1, 0, -1, 0, -2, 2}, 0))
}

// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
type p018_9msSolution struct{}

func (p018_9msSolution) fourSum(nums []int, target int) [][]int {
  sort.Ints(nums)
  ans := make([][]int, 0)
  nSum(nums, target, 4, []int{}, &ans)
  return ans
}

func nSum(nums []int, target int, n int, prefix []int, ans *[][]int) {
  if len(nums) < n || nums[0]*n > target || nums[len(nums)-1]*n < target || n < 2 {
    return
  }
  if n == 2 {
    lo, hi := 0, len(nums)-1
    for lo < hi {
      if nums[lo]+nums[hi] == target {
        *ans = append(*ans, append(prefix, nums[lo], nums[hi]))
        for lo < hi && nums[lo] == nums[lo+1] {
          lo++
        }
        for hi > lo && nums[hi] == nums[hi-1] {
          hi--
        }
        lo++
        hi--
      } else if nums[lo]+nums[hi] > target {
        hi--
      } else {
        lo++
      }
    }
  } else {
    for i := 0; i < len(nums)-n+1; i++ {
      if i == 0 || nums[i] != nums[i-1] {
        nSum(nums[i+1:], target-nums[i], n-1, append(prefix, nums[i]), ans)
      }
    }
  }
}

// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
type p018_MySolution struct {
}

func (p018_MySolution) fourSum(nums []int, target int) [][]int {
  sort.Ints(nums)

  curr := make([]int, 0, 0)
  res := make([][]int, 0, 0)
  distinctMap := make(map[string]bool, 0)
  dfs(nums, 0, 4, target, target, &curr, &res, distinctMap)
  return res
}

func dfs(nums []int, start, numLeft, sumLeft, target int, curr *[]int, res *[][]int, distinctMap map[string]bool) {
  if numLeft == 0 {
    if checkSum(*curr, target) {
      copied := make([]int, 4, 4)
      copy(copied, *curr)
      s := toString(copied)
      if ok, _ := distinctMap[s]; !ok {
        distinctMap[s] = true
        *res = append(*res, copied)
      }
    }
    return
  }

  if start == len(nums) || numLeft > len(nums)-start {
    return
  }

  *curr = append(*curr, nums[start])
  dfs(nums, start+1, numLeft-1, sumLeft-nums[start], target, curr, res, distinctMap)
  *curr = (*curr)[:len(*curr)-1]
  if start < len(nums)-1 && (nums[start] > sumLeft && nums[start] > 0) {
    return
  }
  dfs(nums, start+1, numLeft, sumLeft, target, curr, res, distinctMap)
}

func checkSum(nums []int, target int) bool {
  sum := 0
  for _, n := range nums {
    sum += n
  }
  return target == sum
}

func toString(nums []int) string {
  s := ""
  for _, n := range nums {
    s += strconv.Itoa(n) + ","
  }
  return s
}
