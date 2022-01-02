/*
https://leetcode.com/problems/add-strings/description/

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:
    The length of both num1 and num2 is < 5100.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

package main

import (
  "fmt"
)

func addStrings(num1 string, num2 string) string {
  len1 := len(num1)
  len2 := len(num2)

  maxLen := len1
  if maxLen < len2 {
    maxLen = len2
  }

  res := make([]byte, maxLen+1)
  var carry byte
  for i, j, k := len1-1, len2-1, maxLen; i >= 0 || j >= 0 || carry == 1; i, j, k = i-1, j-1, k-1 {
    if i >= 0 {
      res[k] = res[k] + (num1[i] - '0')
    }
    if j >= 0 {
      res[k] = res[k] + (num2[j] - '0')
    }
    res[k] = res[k] + carry
    carry = res[k] / 10
    res[k] = res[k] % 10
    res[k] = '0' + res[k]
  }

  if res[0] == 0 {
    return string(res[1:])
  }
  return string(res)
}

func main() {
  fmt.Println(addStrings("999", "1"))
}
