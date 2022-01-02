/*
https://leetcode.com/problems/judge-route-circle/description/

Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:
    Input: "UD"
    Output: true
Example 2:
    Input: "LL"
    Output: false
*/

package main

import (
  "fmt"
  "strings"
)

func judgeCircle(moves string) bool {
  left, up := 0, 0
  for _, b := range []byte(moves) {
    switch b {
    case 'U':
      up++
    case 'D':
      up--
    case 'L':
      left++
    case 'R':
      left--
    default:
      return false
    }
  }
  return left == 0 && up == 0
}

func main() {
  fmt.Println(judgeCircle("UDLRR"))
}

type p657_OneLinerSolution int

func (p657_OneLinerSolution) judgeCircle(moves string) bool {
  return strings.Count(moves, "U") == strings.Count(moves, "D") && strings.Count(moves, "L") == strings.Count(moves, "R")
}
