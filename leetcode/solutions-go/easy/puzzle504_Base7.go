/*
https://leetcode.com/problems/base-7/description/

Given an integer, return its base 7 string representation.

Example 1:
    Input: 100
    Output: "202"
Example 2:
    Input: -7
    Output: "-10"
Note: The input will be in range of [-1e7, 1e7].
*/
package main

import (
  "fmt"
  "math"
  "strconv"
)

func convertToBase7(num int) string {
  pn := int(math.Abs(float64(num)))
  res := ""
  for pn > 0 {
    res = strconv.Itoa(pn%7) + res
    pn = pn / 7
  }
  if num < 0 {
    res = "-" + res
  }
  if len(res) == 0 {
    res = "0"
  }
  return res
}

func main() {
  fmt.Println(convertToBase7(-7))
  fmt.Println(convertToBase7(100))
  fmt.Println(convertToBase7(613))
  fmt.Println(convertToBase7(2908753492))

}
