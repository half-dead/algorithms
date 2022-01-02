/*
https://leetcode.com/problems/reverse-pairs/description/

Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

You need to return the number of important reverse pairs in the given array.

Example1:
  Input: [1,3,2,3,1]
  Output: 2
Example2:
  Input: [2,4,3,5,1]
  Output: 3
Note:
  The length of the given array will not exceed 50,000.
  All the numbers in the input array are in the range of 32-bit integer.
 */

package main

import (
  "fmt"
  "time"
  "io/ioutil"
  "strings"
  "strconv"
)

func reversePairs(nums []int) int {
  dict := make(map[int][]int, len(nums))
  for i, n := range nums {
    dict[n] = append(dict[n], i)
  }

  res := 0
  for n, appearances := range dict {
    pc, pos, n2 := 0, 0, n<<1
    for j := 0; j < len(appearances); j++ {
      c := pc
      for k := pos; k < appearances[j]; k++ {
        if nums[k] > n2 {
          c++
        }
        pos++
      }
      pc = c
      res += c
    }
  }
  return res
}

func binarySearch(nums []int, n int) int {
  n <<= 1
  left, right := 0, len(nums)-1

  for ; left <= right; {
    mid := (left + right) / 2
    if nums[mid] > n && (mid-left < 1 || nums[mid-1] <= n) {
      return mid
    } else if nums[mid] > n {
      right = mid
    } else {
      left = mid + 1
    }
  }
  return -1
}

func main() {
  bytes, _ := ioutil.ReadFile("/Users/halfdead/workspace/src/github.com/half-dead/leetcode/algorithms.go/hard/p493_case.txt")
  sarr := strings.Split(string(bytes), ",")
  arr := make([]int, len(sarr))
  for i, s := range sarr {
    arr[i], _ = strconv.Atoi(s)
  }
  fmt.Println(time.Now().String())
  fmt.Println(reversePairs(arr))
  fmt.Println(time.Now().String())
  fmt.Println(reversePairsStraight(arr))
  fmt.Println(time.Now().String())
}

// O(n^2) time complexity, couldn't pass, but easy to understand
func reversePairsStraight(nums []int) int {
  res := 0
  for i := 0; i < len(nums)-1; i++ {
    if nums[i]&1 != 0 {
      nums[i] = nums[i]>>1 + 1
    } else {
      nums[i] = nums[i] >> 1
    }
    for j := i + 1; j < len(nums); j++ {
      if nums[i] > nums[j] {
        res++
      }
    }
  }
  return res
}
