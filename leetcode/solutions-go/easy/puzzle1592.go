// https://leetcode.com/problems/rearrange-spaces-between-words/

package main

import (
  "fmt"
  "strings"
)

func reorderSpaces(text string) string {
  spaces := strings.Count(text, " ")
  words := strings.Fields(text)
  gap, extra, parts := 0, spaces, len(words)-1
  if parts > 0 {
    gap, extra = spaces/parts, spaces%parts
  }
  return strings.Join(words, strings.Repeat(" ", gap)) + strings.Repeat(" ", extra)
}

func main() {
  fmt.Println(reorderSpaces("  this   is  a sentence "))
  fmt.Println(reorderSpaces(" practice   makes   perfect"))
  fmt.Println(reorderSpaces("hello   world"))
  fmt.Println(reorderSpaces("  walks  udp package   into  bar a"))
  fmt.Println(reorderSpaces("a"))
}
