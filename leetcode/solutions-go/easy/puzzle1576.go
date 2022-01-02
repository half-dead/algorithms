// https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
package main

import "fmt"

func modifyString(s string) string {
  bytes := []byte(s)
  slen := len(s)
  for i, c := range bytes {
    if c == '?' {
      var b byte
      for b = 'a'; b <= 'z'; b++ {
        if i > 0 && bytes[i-1] == b {
          continue
        } else if i+1 < slen && bytes[i+1] == b {
          continue
        } else {
          bytes[i] = b
          break;
        }
      }
    }
  }
  return string(bytes)
}

func main() {
  fmt.Println(modifyString("?zs"))
  fmt.Println(modifyString("ubv?w"))
  fmt.Println(modifyString("j?qg??b"))
  fmt.Println(modifyString("??yw?ipkj?"))
}
