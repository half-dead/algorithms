/*
https://leetcode.com/problems/reverse-words-in-a-string-iii/description/

Given a string, you need to reverse the order of characters in each word within a sentence
  while still preserving whitespace and initial word order.

Example 1:
  Input: "Let's take LeetCode contest"
  Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */

package main

import "fmt"

func reverseWords(s string) string {
  bytes := []byte(s)
  left, right := 0, 0
  for i := 0; i < len(bytes); i++ {
    if bytes[i] == ' ' || i == len(bytes)-1 {
      right = i - 1
      if i == len(bytes)-1 {
        right++
      }
      for ; left < right; {
        bytes[left], bytes[right] = bytes[right], bytes[left]
        left++
        right--
      }
      left = i + 1
    }

  }
  return string(bytes)
}

func main() {
  fmt.Println(reverseWords("Let's take LeetCode contest"))
}
