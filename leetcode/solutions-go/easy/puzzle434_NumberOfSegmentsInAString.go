/*
https://leetcode.com/problems/number-of-segments-in-a-string/description/

Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:
    Input: "Hello, my name is John"
    Output: 5
*/

package main

import (
  "fmt"
  "strings"
)

func countSegments(s string) int {
  res, i, sLen := 0, 0, len(s)
  for i < sLen {
    if s[i] != ' ' {
      res++
      i++
      ni := strings.IndexRune(s[i:], ' ')
      if ni != -1 {
        i += ni
      } else {
        break
      }
    } else {
      i++
    }
  }
  return res
}

func main() {
  fmt.Println(countSegments("Hello, my name is John"))
}
