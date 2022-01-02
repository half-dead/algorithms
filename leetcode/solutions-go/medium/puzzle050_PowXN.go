/*
https://leetcode.com/problems/powx-n/description/

Implement pow(x, n).


Example 1:
    Input: 2.00000, 10
    Output: 1024.00000

Example 2:
    Input: 2.10000, 3
    Output: 9.26100
*/

package main

import (
  "fmt"
)

func myPow(x float64, n int) float64 {
  res := 1.0
  if n < 0 {
    n = -n
    x = 1 / x
  }

  for i := 0; i < n; i++ {
    t := res * x
    if t == res {
      return res
    } else if t == -res {
      if n%2 == 0 {
        return -t
      } else {
        return t
      }
    }

    res = t
  }
  return res
}

func main() {
  fmt.Println(myPow(2.000, 10))
}
