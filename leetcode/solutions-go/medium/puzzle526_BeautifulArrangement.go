/*
https://leetcode.com/problems/beautiful-arrangement/description/

Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully
if one of the following is true for the ith position (1 <= i <= N) in this array:
  The number at the ith position is divisible by i.
  i is divisible by the number at the ith position.

Now given N, how many beautiful arrangements can you construct?

Example 1:
  Input: 2
  Output: 2
  Explanation:
  The first beautiful arrangement is [1, 2]:
  Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
  Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
  The second beautiful arrangement is [2, 1]:
  Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
  Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
Note:
  N is a positive integer and will not exceed 15.
 */

package main

import (
  "fmt"
  "time"
)

func countArrangement(n int) int {
  candidates := make([][]int, 0)
  for i := 1; i <= n; i++ {
    candidate := make([]int, 0)
    for j := 1; j <= n; j++ {
      if j%i == 0 || i%j == 0 {
        candidate = append(candidate, j)
      }
    }
    candidates = append(candidates, candidate)
  }
  return recur(candidates, make(map[int]bool), 0)
}

func recur(candidates [][]int, marker map[int]bool, index int) int {
  res := 0
  for _, c := range candidates[index] {
    if !marker[c] {
      if index == len(candidates)-1 {
        res++
      } else {
        marker[c] = true
        res += recur(candidates, marker, index+1)
        marker[c] = false
      }
    }
  }
  return res
}

func main() {
  begin := time.Now()
  for i := 1; i <= 20; i++ {
    fmt.Println(countArrangement(i))
  }
  d := time.Since(begin)
  fmt.Println(d.String())
}
