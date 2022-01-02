/*
https://leetcode.com/problems/partition-labels/description/

A string S of lowercase letters is given. We want to partition this string into as many parts as possible
so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
  Input: S = "ababcbacadefegdehijhklij"
  Output: [9,7,8]
  Explanation:
    The partition is "ababcbaca", "defegde", "hijhklij".
    This is a partition so that each letter appears in at most one part.
    A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:
  S will have length in range [1, 500].
  S will consist of lowercase letters ('a' to 'z') only.
 */

package main

import (
  "fmt"
  "strings"
)

func partitionLabels(s string) []int {
  res := make([]int, 0)
  rec := make([]bool, 26)

  for ; len(s) > 0; {
    c := s[0]
    lc := strings.LastIndexByte(s, c)
    if lc == 0 {
      res = append(res, 1)
      s = s[1:]
      continue
    } else {
      rec[c-'a'] = true
      substr := s[0 : lc+1]
      for j := 1; j < lc; j++ {
        if !rec[substr[j]-'a'] {
          rec[substr[j]-'a'] = true
          nlc := strings.LastIndexByte(s, substr[j])
          if lc < nlc {
            lc = nlc
            substr = s[0 : lc+1]
          }
        }
      }
      res = append(res, lc+1)
      s = s[lc+1:]
    }
  }
  return res
}

// tricky neat smart
func partitionLabels2(s string) []int {
  result, last := make([]int, 0), make([]int, 26)
  head, tail := 0, 0
  for i, c := range s {
    last[c-'a'] = i
  }
  fmt.Println(last)

  for i, c := range s {
    if last[c-'a'] > tail {
      tail = last[c-'a']
    }
    if i == tail {
      result = append(result, i-head+1)
      head = i + 1
    }
  }

  return result
}

func main() {
  fmt.Println(partitionLabels2("ababcbacadefegdehijhklij"))
}
