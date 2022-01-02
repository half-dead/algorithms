/*
https://leetcode.com/problems/valid-palindrome-ii/description/

Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
    Input: "aba"
    Output: True
Example 2:
    Input: "abca"
    Output: True
    Explanation: You could delete the character 'c'.
Note:
    The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
*/

package main

import (
  "fmt"
)

func validPalindrome(s string) bool {
  left, right := 0, len(s)-1

  for s[left] == s[right] && left <= right {
    left++
    right--
  }

  if left >= right-1 {
    return true
  }

  return isPalindromee(s[left:right]) || isPalindromee(s[left+1:right+1])
}

func isPalindromee(s string) bool {
  left, right := 0, len(s)-1
  for s[left] == s[right] && left <= right {
    left++
    right--
  }
  return left >= right
}

func main() {
  fmt.Println(validPalindrome("aba"))
  fmt.Println(validPalindrome("abad"))
  fmt.Println(validPalindrome("daba"))
  fmt.Println(validPalindrome("abcdba"))
  fmt.Println(validPalindrome("abcddba"))
  fmt.Println(validPalindrome("abccddba"))
}
