/*
https://leetcode.com/problems/number-of-substrings-with-only-1s/
*/

package main

import (
  "fmt"
)

func numSub(s string) int {
  var ans int64 = 0
  var cnt int64 = 0
  var mod int64 = 1000000007
  for _, c := range s {
    if c == '1' {
      cnt++
    } else if cnt > 0 {
      ans += cnt * (cnt + 1) / 2
      cnt = 0
    }
  }
  ans += cnt * (cnt + 1) / 2
  return int(ans % mod)
}

func main() {
  fmt.Println(numSub("0101101"))
}
