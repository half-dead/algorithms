// https://leetcode.com/problems/make-the-string-great/

package main

import "fmt"

func makeGood(s string) string {
  dup := make([]byte, len(s))

  pos := 0
  for _, r := range []byte(s) {
    if pos > 0 {
      if r >= 'a' && dup[pos-1] == r-32 {
        pos--
      } else if r <= 'Z' && dup[pos-1] == r+32 {
        pos--
      } else {
        dup[pos] = r
        pos++
      }
    } else {
      dup[pos] = r
      pos++
    }
  }
  return string(dup[:pos])
}

func main() {
  fmt.Println(makeGood("leEeetcode"))
  fmt.Println(makeGood("abBAcC"))
  fmt.Println(makeGood("s"))
}
