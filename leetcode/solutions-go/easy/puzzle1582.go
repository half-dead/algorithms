// https://leetcode.com/problems/special-positions-in-a-binary-matrix/

package main

func numSpecial(mat [][]int) int {
  specialCount, rows, cols := 0, len(mat), len(mat[0])
  cntRow, cntCol := make([]int, rows), make([]int, cols)
  for r, row := range mat {
    for c, cell := range row {
      cntRow[r] += cell
      cntCol[c] += cell
    }
  }
  for r, row := range mat {
    for c, cell := range row {
      if cell == 1 && cntRow[r] == 1 && cntCol[c] == 1 {
        specialCount++
      }
    }
  }
  return specialCount
}
