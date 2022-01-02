/*
https://leetcode.com/problems/convert-a-number-to-hexadecimal/description/

Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

Note:
    All letters in hexadecimal (a-f) must be in lowercase.
    The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
    The given number is guaranteed to fit within the range of a 32-bit signed integer.
    You must not use any method provided by the library which converts/formats the number to hex directly.
Example 1:
    Input:
        26
    Output:
        "1a"
Example 2:
    Input:
        -1
    Output:
        "ffffffff"
*/

package main

import (
  "fmt"
)

const (
  max = 1 << 32
)

func toHex(num int) string {

  if num == 0 {
    return "0"
  }
  if num < 0 {
    num = max + num
  }

  res := ""
  for num > 0 {
    res = string(toRune(num%16)) + res
    num /= 16
  }
  return res
}

func toRune(num int) rune {
  if num < 10 {
    return rune('0' + num)
  }
  return rune('a' + (num - 10))
}

func main() {
  fmt.Println(toHex(-1))
  fmt.Println(toHex(0))
  fmt.Println(toHex(26))
}
