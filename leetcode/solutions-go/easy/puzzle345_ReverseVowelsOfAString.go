/*
https://leetcode.com/problems/reverse-vowels-of-a-string/description/

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
    Given s = "hello", return "holle".
Example 2:
    Given s = "leetcode", return "leotcede".
Note:
    The vowels does not include the letter "y".


*/

package main

import (
  "fmt"
  "strings"
)

const (
  vowels = "AEIOUaeiou"
)

func reverseVowels(s string) string {
  sLen := len(s)
  left, right := 0, sLen-1
  dup := []byte(s)

  for left < right {
    for left < sLen && strings.IndexByte(vowels, s[left]) == -1 {
      left++
    }
    for right > 0 && strings.IndexByte(vowels, s[right]) == -1 {
      right--
    }
    if left < right {
      dup[left], dup[right] = dup[right], dup[left]
      left++
      right--
    }
  }
  return string(dup)
}

func main() {
  fmt.Println(reverseVowels(".,"))
}
