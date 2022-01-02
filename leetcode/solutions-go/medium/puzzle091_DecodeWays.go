/*
https://leetcode.com/problems/decode-ways/description/

A message containing letters from A-Z is being encoded to numbers using the following mapping:
    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
    Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
    The number of ways decoding "12" is 2.
*/

package main

import (
  "fmt"
)

// TODO
func numDecodings(s string) int {
  sLen := len(s)
  if sLen == 0 || s[0] == '0' {
    return 0
  }

  prev, next := 1, 1
  log091(prev, next)
  for i := 1; i < sLen; i++ {
    b1, b2 := s[i-1], s[i]
    if b2 == '0' {
      next = 0
    }

    if b1 == '1' || b1 == '2' && b2 <= '6' {
      next, prev = next+prev, next
    } else {
      prev = next
    }
    log091(prev, next)
  }
  return next
}

func log091(prev, next int) {
  fmt.Printf("prev=%d, next=%d\n", prev, next)
}

func main() {
  // fmt.Println(puzzle091_divideAndConquerSolution(1).numDecodings("9317949759856497357254398763219839323723136763131916377913495416692666785978758414629119614215967159"))
  // fmt.Println(puzzle091_DfsSolution(1).numDecodings("9317949759856497357254398763219839323723136763131916377913495416692666785978758414629119614215967159"))
  // fmt.Println(numDecodings("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"))
  fmt.Println(nuuuuuuuuumDecodings("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"))
}

func nuuuuuuuuumDecodings(s string) uint64 {
  sLen := len(s)
  if sLen == 0 || s[0] == '0' {
    return 0
  }

  var prev, next uint64
  prev, next = 1, 1
  looooooog091(prev, next)
  for i := 1; i < sLen; i++ {
    b1, b2 := s[i-1], s[i]
    if b2 == '0' {
      next = 0
    }

    if b1 == '1' || b1 == '2' && b2 <= '6' {
      next, prev = next+prev, next
    } else {
      prev = next
    }
    looooooog091(prev, next)
  }
  return next
}

func looooooog091(prev, next uint64) {
  fmt.Printf("prev=%d, next=%d\n", prev, next)
}

type puzzle091_divideAndConquerSolution int

func (puzzle091_divideAndConquerSolution) numDecodings(s string) int {
  return divideAndConquer([]byte(s), 0, len(s))
}

func divideAndConquer(b []byte, start, end int) int {

  left := end - start
  if left <= 0 {
    return 0
  }
  b0 := b[start]
  if b0 == '0' {
    return 0
  }
  if left == 1 {
    if b0 <= '9' {
      return 1
    } else {
      return 0
    }
  }
  if left == 2 {
    res := 0
    if end == len(b) {
      res += divideAndConquer(b, end-2, end-1) * divideAndConquer(b, end-1, end)
    }
    b1 := b[start+1]
    if b0 == '1' || (b0 == '2' && b1 <= '6') {
      res++
    }
    return res
  }
  res := 0
  r1 := divideAndConquer(b, start, start+1)
  if r1 > 0 {
    res += r1 * divideAndConquer(b, start+1, end)
  }
  r2 := divideAndConquer(b, start, start+2)
  if r2 > 0 {
    res += r2 * divideAndConquer(b, start+2, end)
  }
  return res
}

type puzzle091_DfsSolution int

func (puzzle091_DfsSolution) numDecodings(s string) int {
  bytes := []byte(s)
  bLen := len(bytes)
  if bLen == 0 {
    return 0
  }
  res := dfs091(bytes, bLen, 0)
  return res
}

func dfs091(b []byte, bLen, start int) int {
  if start > bLen-1 {
    return 1
  }

  sum := 0
  if b[start] > '0' && b[start] <= '9' {
    flag := false
    for start < bLen {
      if b[start] > '2' {
        start++
        flag = true
      } else if start < bLen-1 && b[start+1] == '0' && (b[start] == '1' || b[start] == '2') {
        start += 2
        flag = true
      } else {
        break
      }
    }
    if flag {
      start--
    }
    if start == bLen {
      return 1
    }

    sum += dfs091(b, bLen, start+1)
    if start+1 < bLen {
      code2 := b[start+1]
      if b[start] == '1' || (b[start] == '2' && code2 <= '6') {
        sum += dfs091(b, bLen, start+2)
      }
    }
  } else {
    return 0
  }

  return sum
}
