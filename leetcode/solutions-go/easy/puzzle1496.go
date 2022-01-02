// https://leetcode.com/problems/path-crossing/

package main

import "fmt"

var directions map[rune]int
var moves [4]int

func init() {
  directions = make(map[rune]int, 4)
  for i, d := range "ESWN" {
    directions[d] = i
  }
  moves = [4]int{100000, -1, -100000, 1}
}

func isPathCrossing(path string) bool {
  mem := make(map[int]bool)
  start := 1000010000
  mem[start] = true

  for _, d := range path {
    start += moves[directions[d]]
    if mem[start] {
      return true
    }
    mem[start] = true
  }
  return false
}

func main() {
  fmt.Println(isPathCrossing("NES"))
  fmt.Println(isPathCrossing("NESWW"))
}
