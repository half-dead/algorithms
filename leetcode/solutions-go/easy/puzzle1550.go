// https://leetcode.com/problems/three-consecutive-odds/
package main

func threeConsecutiveOdds(arr []int) bool {
  cnt := 0
  for _, n := range arr {
    if n%2 != 0 {
      cnt++
      if cnt == 3 {
        return true
      }
    } else {
      cnt = 0
    }
  }
  return false
}
