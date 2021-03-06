/*
https://leetcode.com/problems/repeated-substring-pattern/description/

Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
    Example 1:
        Input: "abab"
        Output: True
        Explanation: It's the substring "ab" twice.
    Example 2:
        Input: "aba"
        Output: False
    Example 3:
        Input: "abcabcabcabc"
        Output: True
        Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
*/

package main

import (
  "fmt"
  "strings"
)

func repeatedSubstringPattern(s string) bool {
  sLen := len(s)
  end := rune(s[sLen-1])

  for i := 0; i < sLen; i++ {
    j := strings.IndexRune(s[i:], end)
    if j == -1 {
      return false
    }
    subLen := i + j + 1
    if subLen > sLen/2 {
      return false
    }
    if sLen%subLen != 0 {
      continue
    }
    if checkRepeat(s, subLen) {
      return true
    } else {
      i += j
    }
  }
  return false
}

func checkRepeat(s string, subLen int) bool {
  for i, c := range []byte(s) {
    if c != s[i%subLen] {
      return false
    }
  }
  return true
}

func main() {
  fmt.Println(repeatedSubstringPattern("babbbbaabb"))
}
