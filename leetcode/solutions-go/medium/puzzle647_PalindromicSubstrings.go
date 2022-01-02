/*
https://leetcode.com/problems/palindromic-substrings/description/

Given a string, your task is to count how many palindromic substrings in this string.
The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
  Input: "abc"
  Output: 3
  Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
  Input: "aaa"
  Output: 6
  Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
Note:
  The input string length won't exceed 1000.
 */

package main

import "fmt"

func main() {
  fmt.Println(countSubstrings("abc"))
  fmt.Println(countSubstrings("aaa"))
  fmt.Println(countSubstrings("abab"))
  fmt.Println(countSubstrings("aaaabcdeeefghiiij"))
}

func countSubstrings(s string) int {
  res := 0
  sLen := len(s)
  for i := 0; i < sLen; i++ {
    left, right := i, i
    for ; left >= 0 && right < sLen && s[left] == s[right]; {
      left--
      right++
    }
    res += (right - left - 2) / 2
  }

  for i, j := 0, 1; j < sLen; {
    left, right := i, j
    if s[left] == s[right] {
      res++
      for ; left >= 0 && right < sLen && s[left] == s[right]; {
        left--
        right++
      }
      res += (right - left - 2) / 2
    }
    i++
    j++
  }

  return res + sLen
}
