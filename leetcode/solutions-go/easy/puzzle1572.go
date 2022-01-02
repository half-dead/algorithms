// https://leetcode.com/problems/matrix-diagonal-sum/

package main

import "fmt"

func diagonalSum(mat [][]int) int {
  n, sum := len(mat), 0
  for d := 0; d < n; d++ {
    sum += mat[d][d] + mat[d][n-d-1]
  }
  if n%2 != 0 {
    sum -= mat[n/2][n/2]
  }
  return sum
}

func main() {
  fmt.Println(diagonalSum([][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}))
  fmt.Println(diagonalSum([][]int{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}}))
  fmt.Println(diagonalSum([][]int{{5}}))
}
