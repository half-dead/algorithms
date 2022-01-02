// https://leetcode.com/problems/shuffle-string/

package main

import "fmt"

func restoreString(s string, indices []int) string {
  bytes := make([]byte, len(s))
  for i, p := range indices {
    bytes[p] = s[i]
  }
  return string(bytes)
}
func main() {
  fmt.Println(restoreString("codeleet", []int{4, 5, 6, 7, 0, 2, 1, 3}))
  fmt.Println(restoreString("abc", []int{0, 1, 2}))
  fmt.Println(restoreString("aiohn", []int{3, 1, 4, 2, 0}))
  fmt.Println(restoreString("aaiougrt", []int{4, 0, 2, 6, 7, 3, 1, 5}))
  fmt.Println(restoreString("art", []int{1, 0, 2}))
}
