/*
https://leetcode.com/problems/longest-palindrome/description/

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:
    Input:
        "abccccdd"
    Output:
        7
    Explanation:
        One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

package main

import "fmt"

func longestPalindrome(s string) int {
  bLen := int('z'-'A') + 1
  b := make([]int, bLen, bLen)
  for _, c := range s {
    b[int(c-'A')]++
  }
  flag := false
  res := 0
  for _, n := range b {
    if !flag && n%2 != 0 {
      flag = true
      res++
    }

    res += n - (n % 2)
  }
  return res
}

func main() {
  fmt.Println(longestPalindrome("abccccdd"))
}
