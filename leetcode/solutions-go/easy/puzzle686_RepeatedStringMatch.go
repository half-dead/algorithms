/*
https://leetcode.com/problems/repeated-string-match/description/

Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".
Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
  The length of A and B will be between 1 and 10000.
 */

package main

import (
  "fmt"
  "strings"
)

// stupid, but fast
func repeatedStringMatch(a string, b string) int {
  originalA := a
  lenA, lenB := len(a), len(b)
  res := lenB / lenA
  if res == 0 {
    res = 1
  } else {
    if lenB%lenA != 0 {
      res ++
    }
  }
  if res > 1 {
    a = strings.Repeat(a, res)
  }
  for ; strings.Index(a, b) == -1; {
    a += originalA
    res++
    if (len(a)-len(b))/len(originalA) > 1 {
      return -1
    }
  }

  return res
}

// imagine param `a` as a cycled linked list, walk through it
func repeatedStringMatch1(a string, b string) int {
  lenA, lenB := len(a), len(b)
  ai, bi, res := 0, 0, 0
  for i := 0; i < lenA; i++ {
    if bi == 0 && a[i] != b[0] {
      continue
    } else {
      ai = i
      for ; a[ai] == b[bi]; {
        ai++
        bi++
        if ai == lenA {
          ai = 0
          res++
        }
        if bi >= lenB {
          if ai != lenA && ai != 0 {
            res++
          }
          return res
        }
      }
      res = 0
      bi = 0
    }
  }
  return -1
}

func main() {
  fmt.Println(repeatedStringMatch("abcd", "cdabcdab"))
  fmt.Println(repeatedStringMatch("a", "aa"))
}
