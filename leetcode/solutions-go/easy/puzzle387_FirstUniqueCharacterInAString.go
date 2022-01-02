/*
https://leetcode.com/problems/first-unique-character-in-a-string/description/

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:
    s = "leetcode"
    return 0.

    s = "loveleetcode",
    return 2.
Note: You may assume the string contain only lowercase letters.
*/

package main

import (
  "fmt"
  "strings"
)

func firstUniqChar(s string) int {
  var chars [256]int

  for _, c := range s {
    chars[int(c)]++
  }

  for i, c := range s {
    if chars[int(c)] == 1 {
      return i
    }
  }
  return -1
}

type puzzle387_StupidSolution int

func (puzzle387_StupidSolution) firstUniqChar(s string) int {
  runes := []rune(s)

  for i, r := range runes {
    if strings.Count(s, string(r)) == 1 {
      return i
    }
  }
  return -1
}

func main() {
  fmt.Println(firstUniqChar("loveleetcode"))
}
