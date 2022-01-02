/*
https://leetcode.com/problems/shortest-distance-to-a-character/description/

Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

Example 1:
  Input: S = "loveleetcode", C = 'e'
  Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
Note:
  S string length is in [1, 10000].
  C is a single character, and guaranteed to be in string S.
  All letters in S and C are lowercase.
 */

package main

import "fmt"

func shortestToChar(s string, c byte) []int {
  sLen := len(s)
  res := make([]int, sLen)
  for i, r := range []byte(s) {
    if r == c {
      res[i] = 0
    } else {
      res[i] = sLen
    }
  }

  for i := 0; i < sLen; i++ {
    if res[i] == 0 {
      dis := 0
      for j := i - 1; j >= 0; j-- {
        dis++
        if res[j] == 0 || res[j] < dis {
          break
        } else {
          res[j] = dis
        }
      }
      dis = 0
      for j := i + 1; j < sLen; j++ {
        dis++
        if res[j] == 0 || res[j] < dis {
          break
        } else {
          res[j] = dis
        }
      }
    }
  }
  return res
}

func main() {
  fmt.Println(shortestToChar("loveleetcode", 'e'))
}
