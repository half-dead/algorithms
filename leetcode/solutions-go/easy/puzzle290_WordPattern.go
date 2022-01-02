/*
https://leetcode.com/problems/word-pattern/description/

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
    pattern = "abba", str = "dog cat cat dog" should return true.
    pattern = "abba", str = "dog cat cat fish" should return false.
    pattern = "aaaa", str = "dog cat cat dog" should return false.
    pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/
package main

import (
  "fmt"
  "strings"
)

func wordPattern(pattern string, str string) bool {
  len1 := len(pattern)

  arr := strings.Split(str, " ")
  len2 := len(arr)

  if len1 != len2 {
    return false
  }

  dict := make(map[string]string)
  cdict := make(map[string]string)
  for i, c := range pattern {
    p := string(c)
    if w, ok := dict[p]; ok {
      if w != arr[i] {
        return false
      }
    } else {
      if _, ok := cdict[arr[i]]; ok {
        return false
      } else {
        dict[p] = arr[i]
        cdict[arr[i]] = p
      }
    }
  }
  return true
}

func main() {
  fmt.Println(wordPattern("abba", "god dog dog god"))
}
