// https://leetcode.com/problems/thousand-separator/

package main

import (
  "fmt"
  "strconv"
)

func thousandSeparator(n int) string {
  s := strconv.Itoa(n)
  sLen := len(s)
  dots := sLen / 3
  if sLen%3 == 0 {
    dots--
  }

  rLen := sLen + dots
  if rLen == sLen {
    return s
  }

  arr := make([]rune, rLen)
  digitIdx, i, pos := sLen-1, 0, rLen-1
  for ; pos >= 0; {
    arr[pos] = rune(s[digitIdx])
    i++
    pos--
    digitIdx--
    if i%3 == 0 && pos >= 0 {
      arr[pos] = '.'
      pos--
    }
  }
  return string(arr)
}

func main() {
  fmt.Println(thousandSeparator(987))
  fmt.Println(thousandSeparator(1234))
  fmt.Println(thousandSeparator(123456789))
  fmt.Println(thousandSeparator(0))
}
