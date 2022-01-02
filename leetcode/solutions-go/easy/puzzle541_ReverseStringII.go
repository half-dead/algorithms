/*
https://leetcode.com/problems/reverse-string-ii/description/

Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string.
If there are less than k characters left, reverse all of them.
If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.

Example:
  Input: s = "abcdefg", k = 2
  Output: "bacdfeg"
Restrictions:
  The string consists of lower English letters only.
  Length of the given string and k will in the range [1, 10000]
 */

package main

import "fmt"

func reverseStr(s string, k int) string {
  bytes := []byte(s)
  slen := len(bytes)
  i := 0
  for ; i < slen; {
    min := min541(slen-i, k)
    for left, right := i, i+min-1; left < right; {
      bytes[left], bytes[right] = bytes[right], bytes[left]
      left ++
      right --
    }
    i += min + k
  }
  return string(bytes)
}

func min541(a, b int) int {
  if a > b {
    return b
  }
  return a
}

func main() {
  fmt.Println(reverseStr("abcdefg", 2))
  fmt.Println(reverseStr("abcd", 4))
}
