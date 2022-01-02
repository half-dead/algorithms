/*
https://leetcode.com/problems/daily-temperatures/description/

Given a list of daily temperatures, produce a list that, for each day in the input,
tells you how many days you would have to wait until a warmer temperature.
If there is no future day for which this is possible, put 0 instead.

For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */

package main

import (
  "fmt"
)

// TODO could figure out, try next time.

func dailyTemperatures(temperatures []int) []int {
  tLen := len(temperatures)
  res := make([]int, tLen)
  for i := tLen - 1; i >= 0; i-- {
    j := i + 1
    for j < tLen && temperatures[i] >= temperatures[j] {
      if res[j] > 0 {
        j += res[j]
      } else {
        j = tLen
      }
    }
    if j < tLen {
      res[i] = j - i
    }
    fmt.Println(res, j)
  }
  return res
}

func main() {
  fmt.Println(dailyTemperatures([]int{73, 74, 75, 71, 69, 72, 76, 73}))
}

func dailyTemperatures1(temperatures []int) []int {
  res := make([]int, len(temperatures))
  arr := make([]int, 101)
  for j := len(temperatures) - 1; j >= 0; j-- {
    t := temperatures[j]
    arr[t] = j

    min := 30001
    for k := t + 1; k < 101; k++ {
      distance := arr[k] - j
      if distance > 0 {
        if min > distance {
          min = distance
        }
      }
    }
    if min == 30001 {
      min = 0
    }
    res[j] = min
  }
  return res
}
