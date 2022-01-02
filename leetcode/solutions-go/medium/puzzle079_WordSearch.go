/*
https://leetcode.com/problems/word-search/description/

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
    Given board =

    [
      ['A','B','C','E'],
      ['S','F','C','S'],
      ['A','D','E','E']
    ]
    word = "ABCCED", -> returns true,
    word = "SEE", -> returns true,
    word = "ABCB", -> returns false.

*/

package main

import (
  "fmt"
  "strconv"
)

func exist(board [][]byte, word string) bool {
  rows := len(board)
  cols := len(board[0])

  flags := make([][]int, rows, rows)
  for i := 0; i < rows; i++ {
    flags[i] = make([]int, cols, cols)
  }
  for i := 0; i < rows; i++ {
    for j := 0; j < cols; j++ {
      if check079(board, rows, cols, i, j, word, 0, flags) {
        printSteps(flags, len(word))
        return true
      }
    }
  }
  return false
}

func check079(board [][]byte, rows, cols, row, col int, word string, index int, flags [][]int) bool {
  if index == len(word) {
    return true
  }

  if row < 0 || col < 0 || row >= rows || col >= cols {
    return false
  }
  if board[row][col] != word[index] || flags[row][col] > 0 {
    return false
  }

  flags[row][col] = index + 1
  if check079(board, rows, cols, row-1, col, word, index+1, flags) {
    return true
  }
  if check079(board, rows, cols, row+1, col, word, index+1, flags) {
    return true
  }
  if check079(board, rows, cols, row, col-1, word, index+1, flags) {
    return true
  }
  if check079(board, rows, cols, row, col+1, word, index+1, flags) {
    return true
  }
  flags[row][col] = 0
  return false
}

func printSteps(flags [][]int, wordLen int) {
  w := 0
  for wordLen > 0 {
    w++
    wordLen /= 10
  }
  for _, r := range flags {
    fmt.Print("[")
    for _, c := range r {
      fmt.Printf("%"+strconv.Itoa(w)+"d ", c)
    }
    fmt.Print("]")
    fmt.Println()
  }
}

func main() {
  ans := exist([][]byte{
    []byte("ABCDEFGHIJ"),
    []byte("KLMNOPQRST"),
    []byte("UVWXYZQAZW"),
    []byte("SXEDCRFVTG"),
    []byte("BYHNUJMIKO"),
    []byte("LPZXCVBNMA"),
    []byte("SDFGHJKLQW"),
    []byte("ERTYUIOPZS"),
    []byte("EXDRCFTVGY"),
    []byte("BHUNJIMKOL"),
  }, "RXDRYGX")

  fmt.Println(ans)
}
